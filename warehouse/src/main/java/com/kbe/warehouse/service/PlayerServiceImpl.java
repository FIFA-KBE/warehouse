package com.kbe.warehouse.service;

import com.kbe.warehouse.model.Player;
import com.kbe.warehouse.repository.PlayerRepository;
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
