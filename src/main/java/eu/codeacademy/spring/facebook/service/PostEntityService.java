package eu.codeacademy.spring.facebook.service;


import eu.codeacademy.spring.facebook.entity.PostEntity;
import eu.codeacademy.spring.facebook.model.Post;
import eu.codeacademy.spring.facebook.request.PostRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostEntityService {

    List<Post> getAllPosts();

    List<PostEntity> getAllPostEntities();

    void createNewPost(PostRequest request);


    void editPost(PostRequest postRequest);

    void deletePost(Long postId);
}
