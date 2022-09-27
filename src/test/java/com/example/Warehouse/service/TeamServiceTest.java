package com.example.Warehouse.service;

import com.example.Warehouse.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class TeamServiceTest {

    @InjectMocks
    private TeamServiceImpl teamService;

    @Mock
    private TeamRepository teamRepository;

    @Test
    public void testGetAllTeams() {
        teamService.getAllTeams();

        Mockito.verify(teamRepository, Mockito.times(1)).findAllTeams();
    }
}
