package it.uniroma3.football.controller;



import it.uniroma3.football.model.AppUser;
import it.uniroma3.football.model.Comment;
import it.uniroma3.football.model.Match;


import it.uniroma3.football.service.AppUserService;
import it.uniroma3.football.service.CommentService;
import it.uniroma3.football.service.MatchService;


import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
@RequestMapping("/comments")
public class CommentController {



    private final CommentService commentService;

    private final MatchService matchService;

    private final AppUserService appUserService;




    public CommentController(CommentService commentService,
                             MatchService matchService,
                             AppUserService appUserService){


        this.commentService = commentService;

        this.matchService = matchService;

        this.appUserService = appUserService;

    }






    @PostMapping("/match/{matchId}")
    public String addComment(

            @PathVariable("matchId") Long matchId,

            @RequestParam("text") String text,

            Authentication authentication,

            RedirectAttributes redirectAttributes){





        if(text == null || text.isBlank()){



            redirectAttributes.addFlashAttribute(

                    "error",

                    "Il commento non può essere vuoto"

            );



            return "redirect:/matches/" + matchId;


        }







        Match match =

                matchService.findById(matchId)

                        .orElseThrow();






        AppUser user =

                appUserService.findByUsername(

                        authentication.getName()

                );







        Comment comment =
                new Comment();




        comment.setText(text);



        comment.setMatch(match);



        comment.setUser(user);







        commentService.save(comment);







        return "redirect:/matches/" + matchId;


    }








    @GetMapping("/{id}/edit")
    public String edit(
            @PathVariable("id") Long id,
            Model model,
            Authentication authentication){



        Comment comment =
                commentService.findById(id)
                        .orElseThrow();



        if(!comment.getUser()
                .getUsername()
                .equals(authentication.getName())){


            return "redirect:/matches/"
                    + comment.getMatch().getId();

        }



        model.addAttribute(
                "comment",
                comment
        );


        return "comment-form";

    }








    @PostMapping("/{id}/edit")
    public String update(

            @PathVariable("id") Long id,

            @RequestParam("text") String text,

            Authentication authentication,

            RedirectAttributes redirectAttributes){





        Comment comment =

                commentService.findById(id)

                        .orElseThrow();





        if(text == null || text.isBlank()){


            redirectAttributes.addFlashAttribute(

                    "error",

                    "Il commento non può essere vuoto"

            );


            return "redirect:/comments/" + id + "/edit";


        }







        if(comment.getUser()

                .getUsername()

                .equals(authentication.getName())){





            comment.setText(text);



            commentService.save(comment);


        }






        return "redirect:/matches/"

                + comment.getMatch().getId();


    }


}