package com.example.Warehouse.repository;

import com.example.Warehouse.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query(value = "SELECT e FROM Team e")
    List<Team> findAllTeams();

}
