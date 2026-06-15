package it.uniroma3.football.controller;

import it.uniroma3.football.model.Team;
import it.uniroma3.football.service.TeamService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
public class TeamController {




    private final TeamService teamService;





    public TeamController(TeamService teamService){

        this.teamService = teamService;

    }






    @GetMapping("/teams")
    public String getTeams(Model model){


        model.addAttribute(
                "teams",
                teamService.findAll()
        );


        return "teams";

    }








    @GetMapping("/teams/{id}")
    public String getTeam(@PathVariable ("id") Long id,
                          Model model){



        Team team =
                teamService.findById(id)
                        .orElseThrow();




        model.addAttribute(
                "team",
                team
        );



        return "team";

    }




}