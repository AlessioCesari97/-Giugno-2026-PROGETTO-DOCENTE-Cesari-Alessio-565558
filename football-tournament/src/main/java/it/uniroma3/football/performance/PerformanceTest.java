package it.uniroma3.football.performance;



import it.uniroma3.football.model.Team;
import it.uniroma3.football.repository.TeamRepository;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;






//@Component
public class PerformanceTest
        implements CommandLineRunner {




    private final TeamRepository teamRepository;





    public PerformanceTest(
            TeamRepository teamRepository){


        this.teamRepository =
                teamRepository;


    }








    @Override
    @Transactional
    public void run(String... args){



        Long id = 1L;




        System.out.println(
                "\n----- TEST PRESTAZIONI HIBERNATE -----"
        );









        // ================================
        // TEST 1: LAZY
        // ================================


        long startLazy =
                System.nanoTime();




        Team lazy =
                teamRepository
                        .findById(id)
                        .orElseThrow();




        lazy.getPlayers().size();




        long endLazy =
                System.nanoTime();












        // ================================
        // TEST 2: JOIN FETCH
        // ================================


        long startJoin =
                System.nanoTime();





        Team join =
                teamRepository
                        .findByIdWithPlayersJoinFetch(id)
                        .orElseThrow();




        join.getPlayers().size();





        long endJoin =
                System.nanoTime();












        // ================================
        // TEST 3: ENTITY GRAPH
        // ================================



        long startGraph =
                System.nanoTime();





        Team graph =
                teamRepository
                        .findByIdWithPlayersGraph(id)
                        .orElseThrow();





        graph.getPlayers().size();





        long endGraph =
                System.nanoTime();











        System.out.println(
                "LAZY: "
                        +
                        (endLazy - startLazy)
                        +
                        " ns"
        );





        System.out.println(
                "JOIN FETCH: "
                        +
                        (endJoin - startJoin)
                        +
                        " ns"
        );






        System.out.println(
                "ENTITY GRAPH: "
                        +
                        (endGraph - startGraph)
                        +
                        " ns"
        );





        System.out.println(
                "--------------------------------------\n"
        );



    }




}