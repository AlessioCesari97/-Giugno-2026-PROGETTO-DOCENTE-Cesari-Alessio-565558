package it.uniroma3.football.service;



import it.uniroma3.football.model.Match;
import it.uniroma3.football.model.MatchStatus;

import it.uniroma3.football.repository.MatchRepository;


import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import java.util.Optional;





@Service
public class MatchService {




    private final MatchRepository matchRepository;






    public MatchService(MatchRepository matchRepository){


        this.matchRepository =
                matchRepository;


    }









    @Transactional(readOnly = true)
    public List<Match> findAll(){


        return matchRepository.findAll();


    }










    @Transactional(readOnly = true)
    public Optional<Match> findById(Long id){


        return matchRepository.findById(id);


    }









    @Transactional
    public Match save(Match match){







        if(match.getId()!=null){



            Match oldMatch =
                    matchRepository.findById(
                                    match.getId()
                            )
                            .orElseThrow();






            if(oldMatch.getStatus()
                    ==
                    MatchStatus.PLAYED){



                throw new IllegalStateException(
                        "Una partita giocata non può essere modificata"
                );



            }


        }









        if(match.getHomeTeam()!=null
                &&
                match.getAwayTeam()!=null
                &&
                match.getHomeTeam()
                        .getId()
                        .equals(
                                match.getAwayTeam()
                                        .getId()
                        )){



            throw new IllegalArgumentException(
                    "Una squadra non può giocare contro se stessa"
            );


        }









        if(match.getStatus()
                ==
                MatchStatus.SCHEDULED){



            match.setGoalsHome(null);


            match.setGoalsAway(null);


        }









        if(match.getStatus()
                ==
                MatchStatus.PLAYED){



            if(match.getGoalsHome()==null
                    ||
                    match.getGoalsAway()==null){



                throw new IllegalArgumentException(
                        "Inserire il risultato finale"
                );



            }



        }










        return matchRepository.save(match);



    }









    @Transactional
    public void delete(Long id){



        matchRepository.deleteById(id);


    }

    
}