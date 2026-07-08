package it.uniroma3.football.repository;



import it.uniroma3.football.model.Team;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.EntityGraph;


import java.util.List;

import java.util.Optional;






public interface TeamRepository
        extends JpaRepository<Team, Long> {







  







    @Query("""
            select t
            from Team t
            join fetch t.players
            where t.id = :id
            """)
    Optional<Team> findByIdWithPlayersJoinFetch(
            @Param("id") Long id
    );








    @EntityGraph(
            attributePaths = {"players"}
    )
    @Query("""
            select t
            from Team t
            where t.id = :id
            """)
    Optional<Team> findByIdWithPlayersGraph(
            @Param("id") Long id
    );



}