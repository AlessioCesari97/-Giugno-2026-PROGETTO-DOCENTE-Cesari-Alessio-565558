package it.uniroma3.football.repository;


import it.uniroma3.football.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;



public interface MatchRepository  extends JpaRepository<Match, Long> {



}