package com.kbe.warehouse.config;

import com.kbe.warehouse.model.Player;
import com.kbe.warehouse.model.Team;
import com.kbe.warehouse.repository.PlayerRepository;
import com.kbe.warehouse.repository.TeamRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoadCsvData implements ApplicationRunner {

    PlayerRepository playerRepository;
    TeamRepository teamRepository;

    @Autowired
    public LoadCsvData(PlayerRepository playerRepository, TeamRepository teamRepository) {
        super();
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Value("PlayerData.csv")
    private String playerFile;

    @Value("TeamData.csv")
    private String teamFile;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadPlayers();
        loadTeams();
    }

    private void loadPlayers() throws IOException, URISyntaxException {
        try (Reader reader = Files.newBufferedReader(Paths.get(this.getClass().getClassLoader().getResource(playerFile).toURI()))) {
            CsvToBeanBuilder<Player> builder = new CsvToBeanBuilder<>(reader);
            builder.withType(Player.class);
            List<Player> players = builder.build().parse();
            playerRepository.saveAll(players);
        }
    }

    private void loadTeams() throws IOException, URISyntaxException  {
        try (Reader reader = Files.newBufferedReader(Paths.get(this.getClass().getClassLoader().getResource(teamFile).toURI()))) {
            CsvToBeanBuilder<Team> builder = new CsvToBeanBuilder<>(reader);
            builder.withType(Team.class);
            List<Team> teams = builder.build().parse();
            teamRepository.saveAll(teams);
        }
    }
}