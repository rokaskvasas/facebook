package eu.codeacademy.spring.facebook.service;

import eu.codeacademy.spring.facebook.entity.CommentEntity;
import eu.codeacademy.spring.facebook.model.Comments;
import eu.codeacademy.spring.facebook.request.CommentRequest;

import java.util.List;

public interface CommentEntityService {

    void createNewComment(CommentRequest request);

    void editComment(CommentRequest commentRequest);

    List<Comments> getAllComments();

    List<CommentEntity> getAllCommentEntities();


    void deleteComment(Long commentId);
}
