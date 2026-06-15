package it.uniroma3.football.repository;


import it.uniroma3.football.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TournamentRepository  extends JpaRepository<Tournament, Long> {



}