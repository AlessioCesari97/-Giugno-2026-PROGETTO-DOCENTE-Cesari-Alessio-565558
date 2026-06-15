package it.uniroma3.football.dto;



import it.uniroma3.football.model.Team;



public class StandingDTO {


    private Team team;


    private int points;




    public StandingDTO(Team team){

        this.team = team;

        this.points = 0;

    }




    public Team getTeam(){

        return team;

    }




    public int getPoints(){

        return points;

    }





    public void addPoints(int points){

        this.points += points;

    }


}