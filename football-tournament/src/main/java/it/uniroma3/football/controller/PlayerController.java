package it.uniroma3.football.controller;


import it.uniroma3.football.model.Player;
import it.uniroma3.football.service.PlayerService;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;




@Controller
public class PlayerController {




    private final PlayerService playerService;




    public PlayerController(PlayerService playerService){


        this.playerService =
                playerService;


    }






    @GetMapping("/players/{id}")
    public String getPlayer(

            @PathVariable("id") Long id,

            Model model){





        Player player =

                playerService.findById(id)

                        .orElseThrow();





        model.addAttribute(
                "player",
                player
        );




        return "player";


    }



}
