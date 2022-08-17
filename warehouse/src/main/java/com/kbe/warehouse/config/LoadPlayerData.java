package com.kbe.warehouse.config;

import com.kbe.warehouse.model.Player;
import com.kbe.warehouse.repository.PlayerRepository;
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


public class LoadPlayerData implements ApplicationRunner {
    PlayerRepository playerRepository;

    @Autowired
    public LoadPlayerData(PlayerRepository playerRepository) {
        super();
        this.playerRepository = playerRepository;
    }

    @Value("PlayersData.csv")
    private String playerFile;

    @Override
    public void run(ApplicationArguments args) throws IOException, URISyntaxException {
        Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(playerFile).toURI()));
        List<Player> beans = new CsvToBeanBuilder<Player>(reader).withType(Player.class)
                .build().parse();
        for (Player playerDetail : beans) {
            playerRepository.save(playerDetail);
        }
    }
}
