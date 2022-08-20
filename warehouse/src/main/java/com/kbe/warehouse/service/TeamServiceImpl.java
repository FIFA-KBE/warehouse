package com.kbe.warehouse.service;

import com.kbe.warehouse.model.Team;
import com.kbe.warehouse.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    private TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        super();
        this.teamRepository = teamRepository;
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAllTeams();
    }

    public Team getTeam(Integer id) {
        return teamRepository.findTeamById(id);
    }
}

