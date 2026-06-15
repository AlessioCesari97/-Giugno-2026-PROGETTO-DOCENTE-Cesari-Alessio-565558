package it.uniroma3.football.model;



import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.ArrayList;
import java.util.List;






@Entity
public class AppUser {





    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;






    @NotBlank
    @Column(unique = true)
    private String username;






    @NotBlank
    private String password;






    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;









    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Comment> comments =
            new ArrayList<>();









    public AppUser(){

    }








    public Long getId(){

        return id;

    }



    public void setId(Long id){

        this.id=id;

    }








    public String getUsername(){

        return username;

    }





    public void setUsername(String username){

        this.username=username;

    }








    public String getPassword(){

        return password;

    }






    public void setPassword(String password){

        this.password=password;

    }








    public Role getRole(){

        return role;

    }






    public void setRole(Role role){

        this.role=role;

    }








    public List<Comment> getComments(){

        return comments;

    }






    public void setComments(List<Comment> comments){

        this.comments=comments;

    }



}