package it.uniroma3.football.repository;


import it.uniroma3.football.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface AppUserRepository  extends JpaRepository<AppUser, Long> {



    Optional<AppUser> findByUsername(String username);



}