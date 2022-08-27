package com.example.Warehouse.repository;

import com.example.Warehouse.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query(value = "SELECT e FROM Player e")
    List<Player> findAllPlayers();

    @Query(value = "SELECT e FROM Player e WHERE e.Name = ?1")
    Player findPlayerByName(String name);
}
