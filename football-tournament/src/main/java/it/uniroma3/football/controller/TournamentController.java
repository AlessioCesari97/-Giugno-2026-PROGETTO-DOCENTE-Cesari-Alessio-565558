package it.uniroma3.football.controller;



import it.uniroma3.football.model.Tournament;
import it.uniroma3.football.service.TournamentService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
public class TournamentController {




    private final TournamentService tournamentService;





    public TournamentController(TournamentService tournamentService){

        this.tournamentService = tournamentService;

    }






    @GetMapping("/tournaments")
    public String getTournaments(Model model){


        model.addAttribute(
                "tournaments",
                tournamentService.findAll()
        );


        return "tournaments";

    }







    @GetMapping("/tournaments/{id}")
    public String getTournament(

            @PathVariable("id") Long id,

            @RequestParam(required = false)
            String teamKeyword,

            @RequestParam(required = false)
            String matchKeyword,

            Model model){





        Tournament tournament =

                tournamentService.findById(id)

                        .orElseThrow();






        model.addAttribute(
                "tournament",
                tournament
        );



        model.addAttribute(
                "teamKeyword",
                teamKeyword
        );



        model.addAttribute(
                "matchKeyword",
                matchKeyword
        );



        return "tournament";


    }



    @GetMapping("/tournaments/{id}/standing")
    public String getStanding(@PathVariable ("id") Long id,
                              Model model){


        model.addAttribute(
                "standing",
                tournamentService.getStanding(id)
        );


        return "standing";

    }



}