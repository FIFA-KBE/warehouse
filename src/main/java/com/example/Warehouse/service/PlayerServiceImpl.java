package com.example.Warehouse.service;

import com.example.Warehouse.model.Player;
import com.example.Warehouse.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {
    PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        super();
        this.playerRepository = playerRepository;
    }
    public List<Player> getAllPlayers() {
        return playerRepository.findAllPlayers();
    }
}
