package it.uniroma3.football.controller;



import it.uniroma3.football.model.Tournament;

import it.uniroma3.football.service.TournamentService;
import it.uniroma3.football.service.TeamService;


import jakarta.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;







@Controller
@RequestMapping("/admin/tournaments")
public class AdminTournamentController {





    private final TournamentService tournamentService;


    private final TeamService teamService;







    public AdminTournamentController(
            TournamentService tournamentService,
            TeamService teamService){



        this.tournamentService =
                tournamentService;



        this.teamService =
                teamService;


    }








    @GetMapping
    public String list(Model model){



        model.addAttribute(
                "tournaments",
                tournamentService.findAll()
        );



        return "admin/tournaments";


    }











    @GetMapping("/new")
    public String createForm(Model model){



        model.addAttribute(
                "tournament",
                new Tournament()
        );



        model.addAttribute(
                "teams",
                teamService.findAll()
        );



        return "admin/tournament-form";


    }










    @PostMapping("/save")
    public String save(
            @Valid @ModelAttribute Tournament tournament,
            BindingResult bindingResult,
            Model model){





        if(bindingResult.hasErrors()){



            model.addAttribute(
                    "teams",
                    teamService.findAll()
            );



            return "admin/tournament-form";


        }







        tournamentService.save(tournament);




        return "redirect:/admin/tournaments";


    }











    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model){






        Tournament tournament =
                tournamentService.findById(id)
                        .orElseThrow();







        model.addAttribute(
                "tournament",
                tournament
        );







        model.addAttribute(
                "teams",
                teamService.findAll()
        );







        return "admin/tournament-form";


    }













    @PostMapping("/delete/{id}")
    public String delete(

            @PathVariable("id") Long id,

            RedirectAttributes redirectAttributes){



        try{


            tournamentService.delete(id);



            redirectAttributes.addFlashAttribute(
                    "success",
                    "Torneo eliminato correttamente"
            );


        }


        catch(Exception e){


            redirectAttributes.addFlashAttribute(
                    "error",
                    "Impossibile eliminare: il torneo contiene partite associate"
            );


        }




        return "redirect:/admin/tournaments";


    }



}