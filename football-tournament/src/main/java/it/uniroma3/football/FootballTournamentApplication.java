package it.uniroma3.football;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FootballTournamentApplication {

	public static void main(String[] args) {

		SpringApplication.run(FootballTournamentApplication.class, args);

	}



}
