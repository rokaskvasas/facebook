package eu.codeacademy.spring.facebook.service.impl;

import eu.codeacademy.spring.facebook.entity.CommentEntity;
import eu.codeacademy.spring.facebook.exception.NoSuchCommentExist;
import eu.codeacademy.spring.facebook.exception.NoSuchPostById;
import eu.codeacademy.spring.facebook.exception.UserByIdNotFound;
import eu.codeacademy.spring.facebook.model.Comments;
import eu.codeacademy.spring.facebook.repository.CommentEntityRepository;
import eu.codeacademy.spring.facebook.repository.PostEntityRepository;
import eu.codeacademy.spring.facebook.repository.UserEntityRepository;
import eu.codeacademy.spring.facebook.request.CommentRequest;
import eu.codeacademy.spring.facebook.service.CommentEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentEntityServiceImpl implements CommentEntityService {

    private final CommentEntityRepository commentEntityRepository;

    private final UserEntityRepository userEntityRepository;

    private final PostEntityRepository postEntityRepository;


    @Override
    public void createNewComment(CommentRequest request) {
        var entity = new CommentEntity();
        entity.setCommentText(request.getCommentText());
        entity.setUserId(request.getUserId());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setPostId(request.getPostId());
        entity.setUserComment(userEntityRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new UserByIdNotFound("Couldn't find user by id: " + request.getUserId())));
        entity.setPostComment(postEntityRepository.getByPostId(request.getPostId())
                .orElseThrow(() -> new NoSuchPostById("Couldn't find post by id: " + request.getPostId())));
        commentEntityRepository.saveAndFlush(entity);
    }

    @Override
    @Transactional
    public void editComment(CommentRequest commentRequest) {
        var entity = commentEntityRepository.findById(commentRequest.getCommentId())
                .orElseThrow(() ->
                        new NoSuchCommentExist("Couldn't find comment with id: " + commentRequest.getCommentId()));
        entity.setCommentText(commentRequest.getCommentText());
        entity.setUpdatedAt(LocalDateTime.now());
        commentEntityRepository.save(entity);
    }

    @Override
    public List<Comments> getAllComments() {
        return commentEntityRepository.findAll().stream().map(this::createCommentFromEntity)
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<CommentEntity> getAllCommentEntities() {
        return commentEntityRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        commentEntityRepository.removeByCommentId(commentId);

    }


    private Comments createCommentFromEntity(CommentEntity entity) {
        Comments comment = new Comments();
        comment.setCommentText(entity.getCommentText());
        comment.setUserId(entity.getUserId());
        comment.setCreatedAt(entity.getCreatedAt());
        comment.setPostId(entity.getPostId());
        if (entity.getUpdatedAt() != null) {
            comment.setUpdatedAt(entity.getUpdatedAt());
        }
        return comment;
    }
}
