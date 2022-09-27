package com.example.Warehouse.service;

import com.example.Warehouse.repository.PlayerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class PlayerServiceTest {

    @InjectMocks
    private PlayerServiceImpl playerService;

    @Mock
    private PlayerRepository playerRepository;

    @Test
    public void testGetAllPlayers() {
        playerService.getAllPlayers();

        Mockito.verify(playerRepository, Mockito.times(1)).findAllPlayers();
    }
}
