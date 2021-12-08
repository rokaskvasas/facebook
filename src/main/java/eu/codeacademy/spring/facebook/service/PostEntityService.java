package eu.codeacademy.spring.facebook.service;


import eu.codeacademy.spring.facebook.entity.PostEntity;
import eu.codeacademy.spring.facebook.model.Post;
import eu.codeacademy.spring.facebook.request.PostRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PostEntityService {

    List<Post> getAllPosts();

    List<PostEntity> getAllPostEntities();

    void createNewPost(PostRequest request);

    Page<PostEntity> getAllPostEntitiesPageable(int pageNumber, int pageSize);

    Page<PostEntity> getAllPostEntitiesPageableByUser(int pageNumber, int pageSize, String username);

    void editPost(PostRequest postRequest);

    void deletePostAndComments(Long postId);
}
