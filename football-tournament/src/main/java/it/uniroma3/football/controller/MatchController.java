package it.uniroma3.football.controller;



import it.uniroma3.football.model.Match;
import it.uniroma3.football.service.MatchService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
public class MatchController {




    private final MatchService matchService;





    public MatchController(MatchService matchService){

        this.matchService = matchService;

    }






    @GetMapping("/matches")
    public String getMatches(Model model){


        model.addAttribute(
                "matches",
                matchService.findAll()
        );


        return "matches";

    }







    @GetMapping("/matches/{id}")
    public String getMatch(@PathVariable ("id")Long id,
                           Model model){



        Match match =
                matchService.findById(id)
                        .orElseThrow();




        model.addAttribute(
                "match",
                match
        );



        return "match";

    }



}