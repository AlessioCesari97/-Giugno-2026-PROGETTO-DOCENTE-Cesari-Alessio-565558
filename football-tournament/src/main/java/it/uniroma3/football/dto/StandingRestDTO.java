package it.uniroma3.football.dto;



public class StandingRestDTO {



    private String teamName;


    private int points;






    public StandingRestDTO(
            String teamName,
            int points){


        this.teamName = teamName;


        this.points = points;

    }







    public String getTeamName(){

        return teamName;

    }





    public int getPoints(){

        return points;

    }




}