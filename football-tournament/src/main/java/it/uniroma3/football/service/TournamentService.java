package it.uniroma3.football.service;


import it.uniroma3.football.model.Tournament;
import it.uniroma3.football.repository.TournamentRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import it.uniroma3.football.dto.StandingDTO;
import it.uniroma3.football.model.Match;
import it.uniroma3.football.model.MatchStatus;
import it.uniroma3.football.model.Team;


import java.util.ArrayList;



@Service
public class TournamentService {



    private final TournamentRepository tournamentRepository;



    public TournamentService(TournamentRepository tournamentRepository){

        this.tournamentRepository = tournamentRepository;

    }



    @Transactional(readOnly = true)
    public List<Tournament> findAll(){

        return tournamentRepository.findAll();

    }


    @Transactional(readOnly = true)
    public Optional<Tournament> findById(Long id){

        return tournamentRepository.findById(id);

    }




    @Transactional
    public Tournament save(Tournament tournament){

        return tournamentRepository.save(tournament);

    }


    @Transactional
    public void delete(Long id){

        tournamentRepository.deleteById(id);

    }


    @Transactional(readOnly = true)
    public List<StandingDTO> getStanding(Long tournamentId){


        Tournament tournament =
                tournamentRepository.findById(tournamentId)
                        .orElseThrow();




        List<StandingDTO> standing =
                new ArrayList<>();





        for(Team team : tournament.getTeams()){


            standing.add(
                    new StandingDTO(team)
            );


        }





        for(Match match : tournament.getMatches()){


            if(match.getStatus()
                    == MatchStatus.PLAYED){



                StandingDTO home =
                        findTeam(
                                standing,
                                match.getHomeTeam()
                        );



                StandingDTO away =
                        findTeam(
                                standing,
                                match.getAwayTeam()
                        );





                if(match.getGoalsHome()
                        > match.getGoalsAway()){


                    home.addPoints(3);


                }

                else if(match.getGoalsHome()
                        <
                        match.getGoalsAway()){


                    away.addPoints(3);


                }

                else {


                    home.addPoints(1);

                    away.addPoints(1);

                }


            }


        }

        standing.sort(
                (s1, s2) ->
                        Integer.compare(
                                s2.getPoints(),
                                s1.getPoints()
                        )
        );



        return standing;


    }






    private StandingDTO findTeam(
            List<StandingDTO> standing,
            Team team){



        return standing.stream()

                .filter(s ->
                        s.getTeam()
                                .equals(team)
                )

                .findFirst()

                .orElseThrow();


    }

    
}
