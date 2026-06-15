package it.uniroma3.football.repository;


import it.uniroma3.football.model.Referee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RefereeRepository  extends JpaRepository<Referee, Long> {


}