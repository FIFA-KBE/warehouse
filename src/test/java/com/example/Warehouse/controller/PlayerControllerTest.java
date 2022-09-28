package com.example.Warehouse.controller;

import com.example.Warehouse.service.PlayerService;
import com.example.Warehouse.service.PlayerServiceTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PlayerControllerTest {

    @InjectMocks
    private PlayerController playerController;

    @Mock
    private PlayerService playerService;

    @Test
    public void testGetAllPlayers() {
        playerController.allPlayers();

        Mockito.verify(playerService, Mockito.times(1)).getAllPlayers();
    }
}
