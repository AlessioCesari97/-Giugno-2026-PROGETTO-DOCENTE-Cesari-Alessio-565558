package it.uniroma3.football.controller;



import it.uniroma3.football.model.Player;

import it.uniroma3.football.service.PlayerService;
import it.uniroma3.football.service.TeamService;


import jakarta.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;



@Controller
@RequestMapping("/admin/players")
public class AdminPlayerController {






    private final PlayerService playerService;


    private final TeamService teamService;







    public AdminPlayerController(PlayerService playerService,
                                 TeamService teamService){



        this.playerService =
                playerService;



        this.teamService =
                teamService;


    }









    @GetMapping
    public String list(Model model){



        model.addAttribute(
                "players",
                playerService.findAll()
        );



        return "admin/players";


    }












    @GetMapping("/new")
    public String create(Model model){



        model.addAttribute(
                "player",
                new Player()
        );



        model.addAttribute(
                "teams",
                teamService.findAll()
        );



        return "admin/player-form";


    }








    @PostMapping("/save")
    public String save(

            @Valid @ModelAttribute Player player,

            BindingResult bindingResult,

            Model model,

            @RequestParam("file")
            MultipartFile file)
            throws IOException{





        if(bindingResult.hasErrors()){



            model.addAttribute(
                    "teams",
                    teamService.findAll()
            );



            return "admin/player-form";


        }







        if(!file.isEmpty()){





            String fileName =
                    file.getOriginalFilename();







            String uploadDir =

                    System.getProperty("user.dir")

                            +

                            "/src/main/resources/static/images/";







            File directory =
                    new File(uploadDir);







            if(!directory.exists()){



                directory.mkdirs();



            }









            file.transferTo(

                    new File(

                            uploadDir

                                    +

                                    fileName

                    )

            );







            player.setImage(

                    fileName

            );



        }







        playerService.save(player);







        return "redirect:/admin/players";


    }












    @GetMapping("/edit/{id}")
    public String edit(
            @PathVariable("id") Long id,
            Model model){






        Player player =
                playerService.findById(id)
                        .orElseThrow();







        model.addAttribute(
                "player",
                player
        );





        model.addAttribute(
                "teams",
                teamService.findAll()
        );






        return "admin/player-form";


    }












    @PostMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") Long id){






        playerService.delete(id);






        return "redirect:/admin/players";


    }






}