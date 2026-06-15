package it.uniroma3.football.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;





@Entity
public class Tournament {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;





    @NotBlank
    private String name;





    @NotNull
    private Integer year;





    @Size(max = 1000)
    @Column(length = 1000)
    private String description;






    @OneToMany(
            mappedBy = "tournament",
            fetch = FetchType.LAZY
    )
    private List<Match> matches =
            new ArrayList<>();







    @ManyToMany(
            fetch = FetchType.LAZY
    )
    @JoinTable(
            name = "tournament_team",

            joinColumns =
            @JoinColumn(
                    name = "tournament_id"
            ),

            inverseJoinColumns =
            @JoinColumn(
                    name = "team_id"
            )
    )
    private List<Team> teams =
            new ArrayList<>();







    public Tournament(){

    }







    public Long getId(){

        return id;

    }



    public void setId(Long id){

        this.id=id;

    }






    public String getName(){

        return name;

    }



    public void setName(String name){

        this.name=name;

    }






    public Integer getYear(){

        return year;

    }



    public void setYear(Integer year){

        this.year=year;

    }






    public String getDescription(){

        return description;

    }



    public void setDescription(String description){

        this.description=description;

    }






    public List<Match> getMatches(){

        return matches;

    }



    public void setMatches(List<Match> matches){

        this.matches=matches;

    }






    public List<Team> getTeams(){

        return teams;

    }



    public void setTeams(List<Team> teams){

        this.teams=teams;

    }



}