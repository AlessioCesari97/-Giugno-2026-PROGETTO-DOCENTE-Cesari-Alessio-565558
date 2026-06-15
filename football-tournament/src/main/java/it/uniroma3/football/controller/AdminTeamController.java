package it.uniroma3.football.controller;



import it.uniroma3.football.model.Team;

import it.uniroma3.football.service.TeamService;


import jakarta.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import java.io.IOException;








@Controller
@RequestMapping("/admin/teams")
public class AdminTeamController {






    private final TeamService teamService;








    public AdminTeamController(
            TeamService teamService){



        this.teamService =
                teamService;


    }








    @GetMapping
    public String list(Model model){


        model.addAttribute(
                "teams",
                teamService.findAll()
        );


        return "admin/teams";


    }










    @GetMapping("/new")
    public String create(Model model){






        model.addAttribute(
                "team",
                new Team()
        );






        return "admin/team-form";


    }














    @PostMapping("/save")
    public String save(

            @Valid @ModelAttribute Team team,

            BindingResult bindingResult,

            @RequestParam("file") MultipartFile file,

            Model model){





        if(bindingResult.hasErrors()){



            return "admin/team-form";


        }






        try{



            if(!file.isEmpty()){





                String uploadDir =


                        System.getProperty("user.dir")

                                +

                                "/src/main/resources/static/images/";









                File directory =

                        new File(uploadDir);






                if(!directory.exists()){



                    directory.mkdirs();


                }








                String fileName =

                        file.getOriginalFilename();








                file.transferTo(


                        new File(

                                uploadDir

                                        +

                                        fileName

                        )


                );








                team.setImage(fileName);





            }







            teamService.save(team);






        }



        catch(IOException e){



            model.addAttribute(

                    "error",

                    "Errore caricamento immagine"

            );




            return "admin/team-form";



        }









        return "redirect:/admin/teams";



    }
















    @GetMapping("/edit/{id}")
    public String edit(

            @PathVariable("id") Long id,

            Model model){










        Team team =
                teamService.findById(id)
                        .orElseThrow();










        model.addAttribute(
                "team",
                team
        );










        return "admin/team-form";


    }
















    @PostMapping("/delete/{id}")
    public String delete(

            @PathVariable("id") Long id,

            RedirectAttributes redirectAttributes){





        try{


            teamService.delete(id);



            redirectAttributes.addFlashAttribute(
                    "success",
                    "Squadra eliminata"
            );



        }


        catch(Exception e){



            redirectAttributes.addFlashAttribute(
                    "error",
                    "Impossibile eliminare: squadra presente in partite o tornei"
            );



        }







        return "redirect:/admin/teams";



    }




}