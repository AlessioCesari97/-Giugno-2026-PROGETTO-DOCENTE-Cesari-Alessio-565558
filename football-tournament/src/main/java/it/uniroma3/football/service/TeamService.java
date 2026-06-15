package it.uniroma3.football.service;


import it.uniroma3.football.model.Team;
import it.uniroma3.football.repository.TeamRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service
public class TeamService {



    private final TeamRepository teamRepository;



    public TeamService(TeamRepository teamRepository){

        this.teamRepository = teamRepository;

    }




    @Transactional(readOnly = true)
    public List<Team> findAll(){

        return teamRepository.findAll();

    }




    @Transactional(readOnly = true)
    public Optional<Team> findById(Long id){

        return teamRepository.findById(id);

    }




    @Transactional
    public Team save(Team team){

        return teamRepository.save(team);

    }




    @Transactional
    public void delete(Long id){

        teamRepository.deleteById(id);

    }


    @Transactional(readOnly = true)
    public Team findWithPlayersJoinFetch(Long id){


        return teamRepository
                .findByIdWithPlayersJoinFetch(id)
                .orElseThrow();


    }





    @Transactional(readOnly = true)
    public Team findWithPlayersGraph(Long id){


        return teamRepository
                .findByIdWithPlayersGraph(id)
                .orElseThrow();


    }


  

}