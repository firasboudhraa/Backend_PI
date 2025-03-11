package tn.esprit.backend_pi.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.backend_pi.entity.Comment;
import tn.esprit.backend_pi.service.ICommentService;

import java.util.List;

@Tag(name = "Gestion des Commentaires", description = "API pour la gestion des commentaires")
@RestController
@RequestMapping("/comments")
public class CommentRestController {

    @Autowired
    ICommentService commentService;

    @Operation(summary = "Récupérer tous les commentaires", description = "Retourne la liste de tous les commentaires")
    @GetMapping("/retrieve-all")
    public List<Comment> getComments() {
        return commentService.retrieveAllComments();
    }

    @Operation(summary = "Ajouter un commentaire", description = "Ajoute un commentaire à un post")
    @PostMapping("/add/{post-id}")
    public Comment addComment(@RequestBody Comment comment, @PathVariable("post-id") Long postId) {
        return commentService.addComment(comment, postId);
    }

    @Operation(summary = "Supprimer un commentaire", description = "Supprime un commentaire par ID")
    @DeleteMapping("/remove/{comment-id}")
    public void removeComment(@PathVariable("comment-id") Long commentId) {
        commentService.removeComment(commentId);
    }
}
