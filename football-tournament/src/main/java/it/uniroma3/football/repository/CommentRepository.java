package it.uniroma3.football.repository;


import it.uniroma3.football.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CommentRepository  extends JpaRepository<Comment, Long> {



}