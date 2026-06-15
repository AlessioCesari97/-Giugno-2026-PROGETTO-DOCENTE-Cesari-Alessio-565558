package it.uniroma3.football.model;



import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Past;


import java.time.LocalDate;




@Entity
public class Player {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;





    @NotBlank
    private String firstName;





    @NotBlank
    private String lastName;





    @NotNull
    @Past
    private LocalDate birthDate;





    @NotBlank
    private String role;





    @NotNull
    @Positive
    private Integer height;



    private  String image;



    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "team_id"
    )
    private Team team;








    public Player(){

    }






    public Long getId(){

        return id;

    }



    public void setId(Long id){

        this.id=id;

    }






    public String getFirstName(){

        return firstName;

    }




    public void setFirstName(String firstName){

        this.firstName=firstName;

    }







    public String getLastName(){

        return lastName;

    }




    public void setLastName(String lastName){

        this.lastName=lastName;

    }







    public LocalDate getBirthDate(){

        return birthDate;

    }




    public void setBirthDate(LocalDate birthDate){

        this.birthDate=birthDate;

    }







    public String getRole(){

        return role;

    }





    public void setRole(String role){

        this.role=role;

    }







    public Integer getHeight(){

        return height;

    }




    public void setHeight(Integer height){

        this.height=height;

    }







    public Team getTeam(){

        return team;

    }





    public void setTeam(Team team){

        this.team=team;

    }

    public String getImage(){

        return image;

    }


    public void setImage(String image){

        this.image=image;

    }


}