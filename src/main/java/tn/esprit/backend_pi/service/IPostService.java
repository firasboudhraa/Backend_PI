package tn.esprit.backend_pi.service;

import tn.esprit.backend_pi.entity.Post;

import java.util.List;

public interface IPostService {
    List<Post> retrieveAllPosts();

    Post retrievePost(Long postId);

    Post addPost(Post post);

    void removePost(Long postId);

    Post modifyPost(Post post);
}
