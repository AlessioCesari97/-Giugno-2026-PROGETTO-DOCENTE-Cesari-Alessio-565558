package it.uniroma3.football.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;




@Entity
public class Team {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;





    @NotBlank
    private String name;





    @NotNull
    private Integer foundationYear;





    @NotBlank
    private String city;



    private String image;


    @OneToMany(
            mappedBy = "team",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Player> players =
            new ArrayList<>();







    @ManyToMany(
            mappedBy = "teams",
            fetch = FetchType.LAZY
    )
    private List<Tournament> tournaments =
            new ArrayList<>();









    public Team(){

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






    public Integer getFoundationYear(){

        return foundationYear;

    }




    public void setFoundationYear(Integer foundationYear){

        this.foundationYear=foundationYear;

    }







    public String getCity(){

        return city;

    }




    public void setCity(String city){

        this.city=city;

    }







    public List<Player> getPlayers(){

        return players;

    }




    public void setPlayers(List<Player> players){

        this.players=players;

    }







    public List<Tournament> getTournaments(){

        return tournaments;

    }




    public void setTournaments(List<Tournament> tournaments){

        this.tournaments=tournaments;

    }

    public String getImage(){

        return image;

    }



    public void setImage(String image){

        this.image=image;

    }


}