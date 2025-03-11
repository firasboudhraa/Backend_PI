package tn.esprit.backend_pi.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend_pi.entity.Post;
import tn.esprit.backend_pi.service.IPostService;

import java.util.List;

@Tag(name = "Gestion des Posts", description = "API pour la gestion des posts")
@RestController
@RequestMapping("/posts")
public class PostRestController {

    @Autowired
    IPostService postService;

    @Operation(summary = "Récupérer tous les posts", description = "Retourne la liste de tous les posts")
    @GetMapping("/retrieve-all")
    public List<Post> getPosts() {
        return postService.retrieveAllPosts();
    }

    @Operation(summary = "Récupérer un post", description = "Retourne un post par ID")
    @GetMapping("/retrieve/{post-id}")
    public Post retrievePost(@PathVariable("post-id") Long postId) {
        return postService.retrievePost(postId);
    }

    @Operation(summary = "Ajouter un post", description = "Ajoute un nouveau post")
    @PostMapping("/add")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @Operation(summary = "Supprimer un post", description = "Supprime un post par ID")
    @DeleteMapping("/remove/{post-id}")
    public void removePost(@PathVariable("post-id") Long postId) {
        postService.removePost(postId);
    }

    @Operation(summary = "Modifier un post", description = "Modifie un post existant")
    @PutMapping("/modify")
    public Post modifyPost(@RequestBody Post post) {
        return postService.modifyPost(post);
    }
}
