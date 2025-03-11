package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> retrieveAllComments();

    Comment retrieveComment(Long commentId);

    Comment addComment(Comment comment, Long postId);

    void removeComment(Long commentId);

    Comment modifyComment(Comment comment);
}
