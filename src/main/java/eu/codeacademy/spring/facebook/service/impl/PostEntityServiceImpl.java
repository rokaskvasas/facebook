package eu.codeacademy.spring.facebook.service.impl;


import eu.codeacademy.spring.facebook.entity.PostEntity;
import eu.codeacademy.spring.facebook.exception.UserByIdNotFound;
import eu.codeacademy.spring.facebook.exception.PostNotFound;
import eu.codeacademy.spring.facebook.model.Post;
import eu.codeacademy.spring.facebook.repository.PostEntityRepository;
import eu.codeacademy.spring.facebook.repository.UserEntityRepository;
import eu.codeacademy.spring.facebook.request.PostRequest;
import eu.codeacademy.spring.facebook.service.CommentEntityService;
import eu.codeacademy.spring.facebook.service.PostEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostEntityServiceImpl implements PostEntityService {

    private final PostEntityRepository postEntityRepository;

    private final UserEntityRepository userEntityRepository;

    private final CommentEntityService commentEntityService;

    @Override
    public List<Post> getAllPosts() {
        return postEntityRepository.findAll().stream().map(this::createPostFromEntity).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<PostEntity> getAllPostEntities() {
        return postEntityRepository.findAll();
    }

    @Override
    public Page<PostEntity> getAllPostEntitiesPageable(int pageNumber, int pageSize){
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return postEntityRepository.findAll(page);
    }
//    new Sort(Sort.Direction.ASC, "created_at") TODO:: WHY NO WORK

    @Override
    public void createNewPost(PostRequest request) {
        var entity = new PostEntity();
        entity.setPostText(request.getPostText());
        entity.setUserId(request.getUserId());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUserPost(userEntityRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new UserByIdNotFound("Couldn't find such user by id: "+request.getUserId())));
        postEntityRepository.saveAndFlush(entity);
    }

    @Override
    public void editPost(PostRequest postRequest) {
        var entity = postEntityRepository.findById(postRequest.getPostId())
                .orElseThrow(() -> new PostNotFound("Post wasn't found in DB"));
        entity.setPostText(postRequest.getPostText());
        entity.setUpdatedAt(LocalDateTime.now());
        postEntityRepository.save(entity);
    }

    @Override
    @Transactional
    public void deletePostAndComments(Long postId) {
       var post = postEntityRepository.getByPostId(postId)
               .orElseThrow(() -> new PostNotFound(String.format("Post with such id: %d not found",postId)));
        if(!post.getPostComments().isEmpty()){
            deletePostComments(post);
        }
        postEntityRepository.removePostEntityByPostId(postId);
    }


    private void deletePostComments(PostEntity post) {
        post.getPostComments().forEach(entity -> commentEntityService.deleteComment(entity.getCommentId()));
    }

    private Post createPostFromEntity(PostEntity entity) {
        Post post = new Post();
        post.setPostText(entity.getPostText());
        post.setCreatedAt(LocalDateTime.now());
        return post;
    }
}
