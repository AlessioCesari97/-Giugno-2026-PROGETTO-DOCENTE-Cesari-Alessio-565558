package it.uniroma3.football.service;


import it.uniroma3.football.model.Comment;
import it.uniroma3.football.repository.CommentRepository;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;



@Service
public class CommentService {


    private final CommentRepository commentRepository;



    public CommentService(CommentRepository commentRepository){

        this.commentRepository = commentRepository;

    }




    @Transactional(readOnly = true)
    public List<Comment> findAll(){

        return commentRepository.findAll();

    }





    @Transactional(readOnly = true)
    public Optional<Comment> findById(Long id){

        return commentRepository.findById(id);

    }





    @Transactional
    public Comment save(Comment comment){

        return commentRepository.save(comment);

    }





    @Transactional
    public void delete(Long id){

        commentRepository.deleteById(id);

    }



}