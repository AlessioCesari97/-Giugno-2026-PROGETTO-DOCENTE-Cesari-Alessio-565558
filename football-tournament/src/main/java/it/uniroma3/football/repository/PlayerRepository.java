package it.uniroma3.football.repository;


import it.uniroma3.football.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PlayerRepository  extends JpaRepository<Player, Long> {



}