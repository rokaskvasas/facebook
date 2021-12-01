package eu.codeacademy.spring.facebook.service.impl;


import eu.codeacademy.spring.facebook.entity.PostEntity;
import eu.codeacademy.spring.facebook.exception.NotFoundUserById;
import eu.codeacademy.spring.facebook.exception.PostNotFound;
import eu.codeacademy.spring.facebook.model.Post;
import eu.codeacademy.spring.facebook.repository.PostEntityRepository;
import eu.codeacademy.spring.facebook.repository.UserEntityRepository;
import eu.codeacademy.spring.facebook.request.PostRequest;
import eu.codeacademy.spring.facebook.service.PostEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostEntityServiceImpl implements PostEntityService {

    private final PostEntityRepository postEntityRepository;

    private final UserEntityRepository userEntityRepository;

    @Override
    public List<Post> getAllPosts() {
        return postEntityRepository.findAll().stream().map(this::createPostFromEntity).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public List<PostEntity> getAllPostEntities() {
        return postEntityRepository.findAll();
    }

    @Override
    public void createNewPost(PostRequest request) {
        var entity = new PostEntity();
        entity.setPostText(request.getPostText());
        entity.setUserId(request.getUserId());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUserPost(userEntityRepository.findByUserId(request.getUserId())
                .orElseThrow(() -> new NotFoundUserById("Couldn't find such user by id: "+request.getUserId())));
//        entity.setPostComments(userEntityRepository.findByUserId(request.getUserId()).getUserComments());
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

    private Post createPostFromEntity(PostEntity entity) {
        Post post = new Post();
        post.setPostText(entity.getPostText());
        post.setCreatedAt(LocalDateTime.now());
        return post;
    }
}
