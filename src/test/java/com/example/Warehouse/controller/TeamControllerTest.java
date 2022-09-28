package com.example.Warehouse.controller;

import com.example.Warehouse.service.TeamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TeamControllerTest {

    @InjectMocks
    private TeamController teamController;

    @Mock
    private TeamService teamService;

    @Test
    public void testGetAllTeams() {
        teamController.allTeams();

        Mockito.verify(teamService, Mockito.times(1)).getAllTeams();
    }
}
