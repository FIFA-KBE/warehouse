package com.kbe.warehouse.service;

import com.kbe.warehouse.model.Team;

import java.util.List;

public interface TeamService {
    public List<Team> getAllTeams();
    public Team getTeam(Integer id);
}

