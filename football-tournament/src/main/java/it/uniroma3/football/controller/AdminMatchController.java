package it.uniroma3.football.controller;



import it.uniroma3.football.model.Match;
import it.uniroma3.football.model.MatchStatus;


import it.uniroma3.football.service.MatchService;
import it.uniroma3.football.service.TeamService;
import it.uniroma3.football.service.TournamentService;
import it.uniroma3.football.service.RefereeService;


import jakarta.validation.Valid;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;






@Controller
@RequestMapping("/admin/matches")
public class AdminMatchController {




    private final MatchService matchService;


    private final TeamService teamService;


    private final TournamentService tournamentService;


    private final RefereeService refereeService;






    public AdminMatchController(
            MatchService matchService,
            TeamService teamService,
            TournamentService tournamentService,
            RefereeService refereeService){



        this.matchService =
                matchService;


        this.teamService =
                teamService;


        this.tournamentService =
                tournamentService;


        this.refereeService =
                refereeService;


    }








    @GetMapping
    public String list(Model model){



        model.addAttribute(
                "matches",
                matchService.findAll()
        );



        return "admin/matches";


    }









    @GetMapping("/new")
    public String create(Model model){




        Match match =
                new Match();



        match.setStatus(
                MatchStatus.SCHEDULED
        );



        model.addAttribute(
                "match",
                match
        );




        loadFormData(model);



        return "admin/match-form";


    }










    @PostMapping("/save")
    public String save(

            @Valid @ModelAttribute Match match,

            BindingResult bindingResult,

            Model model){






        if(bindingResult.hasErrors()){



            loadFormData(model);



            return "admin/match-form";


        }






        try{


            matchService.save(match);



        }


        catch(Exception e){



            model.addAttribute(
                    "error",
                    e.getMessage()
            );



            loadFormData(model);



            return "admin/match-form";


        }






        return "redirect:/admin/matches";



    }











    @GetMapping("/edit/{id}")
    public String edit(

            @PathVariable("id") Long id,

            Model model){





        Match match =
                matchService.findById(id)
                        .orElseThrow();




        model.addAttribute(
                "match",
                match
        );



        loadFormData(model);




        return "admin/match-form";



    }









    @PostMapping("/delete/{id}")
    public String delete(

            @PathVariable("id") Long id){




        matchService.delete(id);




        return "redirect:/admin/matches";



    }









    private void loadFormData(Model model){





        model.addAttribute(
                "teams",
                teamService.findAll()
        );




        model.addAttribute(
                "tournaments",
                tournamentService.findAll()
        );




        model.addAttribute(
                "referees",
                refereeService.findAll()
        );


    }



}