package com.example.Warehouse.controller;

import com.example.Warehouse.model.Team;
import com.example.Warehouse.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        super();
        this.teamService = teamService;
    }
    @CrossOrigin
    @GetMapping("/teams")
    public List<Team> allTeams() {
        return teamService.getAllTeams();
    }

}
