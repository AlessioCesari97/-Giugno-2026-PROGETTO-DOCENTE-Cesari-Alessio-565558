package it.uniroma3.football.api;



import it.uniroma3.football.dto.StandingRestDTO;

import it.uniroma3.football.dto.TournamentDTO;


import it.uniroma3.football.service.TournamentService;


import org.springframework.web.bind.annotation.*;


import java.util.List;






@RestController
@RequestMapping("/api/tournaments")
@CrossOrigin(
        origins = "http://localhost:5173"
)
public class StandingRestController {






    private final TournamentService tournamentService;







    public StandingRestController(
            TournamentService tournamentService){



        this.tournamentService =
                tournamentService;


    }










    @GetMapping
    public List<TournamentDTO> tournaments(){






        return tournamentService
                .findAll()

                .stream()

                .map(t ->


                        new TournamentDTO(


                                t.getId(),


                                t.getName()


                        )


                )

                .toList();



    }












    @GetMapping("/{id}/standing")
    public List<StandingRestDTO> standing(
            @PathVariable("id") Long id){






        return tournamentService
                .getStanding(id)


                .stream()


                .map(s ->



                        new StandingRestDTO(



                                s.getTeam()
                                        .getName(),



                                s.getPoints()



                        )


                )


                .toList();



    }





}