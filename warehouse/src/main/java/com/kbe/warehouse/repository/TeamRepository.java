package com.kbe.warehouse.repository;

import com.kbe.warehouse.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query(value = "SELECT e FROM Team e")
    List<Team> findAllTeams();

    @Query(value = "SELECT e FROM Team e WHERE e.id = ?1")
    Team findTeamById(Integer id);
}
