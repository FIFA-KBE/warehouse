package com.kbe.warehouse.controller;

import com.kbe.warehouse.model.Team;
import com.kbe.warehouse.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/teams")
    public List<Team> allTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/teams/{id}")
    public Team getTeam(Integer id) {
        return teamService.getTeam(id);
    }
}
