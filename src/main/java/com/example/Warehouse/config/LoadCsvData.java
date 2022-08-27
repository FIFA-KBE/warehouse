package com.example.Warehouse.config;

import com.example.Warehouse.model.Player;
import com.example.Warehouse.model.Team;
import com.example.Warehouse.repository.PlayerRepository;
import com.example.Warehouse.repository.TeamRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class LoadCsvData implements ApplicationRunner {

    PlayerRepository playerRepository;
    TeamRepository teamRepository;

    @Autowired
    public LoadCsvData(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    @Value("Player.csv")
    private String playerFile;

    @Value("Team.csv")
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

    private void loadTeams() throws IOException, URISyntaxException {
        try (Reader reader = Files.newBufferedReader(Paths.get(this.getClass().getClassLoader().getResource(teamFile).toURI()))) {
            CsvToBeanBuilder<Team> builder = new CsvToBeanBuilder<>(reader);
            builder.withType(Team.class);
            List<Team> teams = builder.build().parse();
            teamRepository.saveAll(teams);
        }
}
}