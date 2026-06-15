package it.uniroma3.football.model;



import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;





@Entity
public class Match {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;





    @NotNull
    private LocalDateTime dateTime;






    @NotBlank
    private String location;






    @PositiveOrZero
    private Integer goalsHome;





    @PositiveOrZero
    private Integer goalsAway;






    @NotNull
    @Enumerated(EnumType.STRING)
    private MatchStatus status;








    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tournament_id")
    private Tournament tournament;








    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="home_team_id")
    private Team homeTeam;








    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="away_team_id")
    private Team awayTeam;








    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="referee_id")
    private Referee referee;








    @OneToMany(
            mappedBy = "match",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments =
            new ArrayList<>();









    public Match(){

    }







    public Long getId(){

        return id;

    }



    public void setId(Long id){

        this.id=id;

    }







    public LocalDateTime getDateTime(){

        return dateTime;

    }




    public void setDateTime(LocalDateTime dateTime){

        this.dateTime=dateTime;

    }








    public String getLocation(){

        return location;

    }




    public void setLocation(String location){

        this.location=location;

    }








    public Integer getGoalsHome(){

        return goalsHome;

    }



    public void setGoalsHome(Integer goalsHome){

        this.goalsHome=goalsHome;

    }







    public Integer getGoalsAway(){

        return goalsAway;

    }




    public void setGoalsAway(Integer goalsAway){

        this.goalsAway=goalsAway;

    }







    public MatchStatus getStatus(){

        return status;

    }



    public void setStatus(MatchStatus status){

        this.status=status;

    }








    public Tournament getTournament(){

        return tournament;

    }




    public void setTournament(Tournament tournament){

        this.tournament=tournament;

    }







    public Team getHomeTeam(){

        return homeTeam;

    }




    public void setHomeTeam(Team homeTeam){

        this.homeTeam=homeTeam;

    }








    public Team getAwayTeam(){

        return awayTeam;

    }





    public void setAwayTeam(Team awayTeam){

        this.awayTeam=awayTeam;

    }







    public Referee getReferee(){

        return referee;

    }




    public void setReferee(Referee referee){

        this.referee=referee;

    }








    public List<Comment> getComments(){

        return comments;

    }



    public void setComments(List<Comment> comments){

        this.comments=comments;

    }




}