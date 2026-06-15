package it.uniroma3.football.dto;



public class TournamentDTO {


    private Long id;


    private String name;





    public TournamentDTO(Long id,
                         String name){


        this.id = id;

        this.name = name;


    }




    public Long getId(){

        return id;

    }



    public String getName(){

        return name;

    }


}