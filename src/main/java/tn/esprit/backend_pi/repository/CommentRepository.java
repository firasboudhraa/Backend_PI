package tn.esprit.backend_pi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.backend_pi.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
