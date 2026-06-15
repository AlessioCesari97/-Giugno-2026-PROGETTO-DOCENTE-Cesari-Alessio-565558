package it.uniroma3.football.model;



import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


import java.time.LocalDateTime;






@Entity
public class Comment {






    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;








    @NotBlank
    @Size(max = 1000)
    @Column(length = 1000)
    private String text;









    @NotNull
    private LocalDateTime creationDate;









    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private AppUser user;










    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "match_id",
            nullable = false
    )
    private Match match;











    public Comment(){


        this.creationDate =
                LocalDateTime.now();


    }










    public Long getId(){

        return id;

    }




    public void setId(Long id){

        this.id=id;

    }








    public String getText(){

        return text;

    }




    public void setText(String text){

        this.text=text;

    }








    public LocalDateTime getCreationDate(){

        return creationDate;

    }





    public void setCreationDate(LocalDateTime creationDate){

        this.creationDate=creationDate;

    }








    public AppUser getUser(){

        return user;

    }





    public void setUser(AppUser user){

        this.user=user;

    }









    public Match getMatch(){

        return match;

    }





    public void setMatch(Match match){

        this.match=match;

    }




}
