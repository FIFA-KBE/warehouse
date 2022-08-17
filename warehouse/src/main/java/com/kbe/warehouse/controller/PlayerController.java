package com.kbe.warehouse.controller;

import com.kbe.warehouse.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        super();
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public ResponseEntity<?> allPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }
}
