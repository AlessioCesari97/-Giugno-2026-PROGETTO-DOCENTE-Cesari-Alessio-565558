package it.uniroma3.football.model;



import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;


import java.util.ArrayList;
import java.util.List;





@Entity
public class Referee {





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;






    @NotBlank
    private String firstName;






    @NotBlank
    private String lastName;







    @NotBlank
    @Column(unique = true)
    private String refereeCode;








    @OneToMany(
            mappedBy = "referee",
            fetch = FetchType.LAZY
    )
    private List<Match> matches =
            new ArrayList<>();










    public Referee(){

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








    public String getRefereeCode(){

        return refereeCode;

    }






    public void setRefereeCode(String refereeCode){

        this.refereeCode=refereeCode;

    }









    public List<Match> getMatches(){

        return matches;

    }







    public void setMatches(List<Match> matches){

        this.matches=matches;

    }




}