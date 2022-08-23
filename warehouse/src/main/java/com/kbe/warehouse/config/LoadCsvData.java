package com.kbe.warehouse.config;

import com.kbe.warehouse.model.Fruit;
import com.kbe.warehouse.model.Player;
import com.kbe.warehouse.model.Team;
import com.kbe.warehouse.repository.FruitRepository;
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
public class LoadCsvData {

    PlayerRepository playerRepository;
    TeamRepository teamRepository;

    /*@Value("PlayerData.csv")
    private String playerFile;

    @Value("TeamData.csv")
    private String teamFile; */

    public LoadCsvData(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }
    public void load(String path){
        Path pathToFile = Paths.get(path+".csv");
        try(BufferedReader br = Files.newBufferedReader(pathToFile)){
            String line = br.readLine();
            line = br.readLine();
            while(line!= null){
                String[] attributes = line.split(",");
                if(path.equals("PlayerData")){
                    createPlayer(attributes);
                } else {
                    createTeam(attributes);
                }
                line = br.readLine();
            }
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void createPlayer(String[] player){
        Player newPlayer = new Player(player[0], player[1], Integer.parseInt(player[2]), player[3], player[4],
                           Double.parseDouble(player[5]), Integer.parseInt(player[6]), player[7]);
    }

    public void createTeam(String[] string){
        String[] players = string[1].replaceAll("\\s","").split("-");
        List<Player> playerList = new ArrayList<>();

        for (int i=0; i < players.length; i++){
            Player player = playerRepository.findPlayerByName(players[i]);
            playerList.add(player);
        }

        Team team = new Team(string[0],playerList,string[2]);
        teamRepository.save(team);
    }

   /* @Autowired
    public LoadCsvData(FruitRepository fruitRepository, PlayerRepository playerRepository, TeamRepository teamRepository) {
        super();
        this.fruitRepository = fruitRepository;
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }


    @Value("PlayerData.csv")
    private String playerFile;

    @Value("TeamData.csv")
    private String teamFile;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadFruits();
        loadPlayers();
        loadTeams();
    }

    private void loadFruits() throws IOException, URISyntaxException {
        try (Reader reader = Files.newBufferedReader(Paths.get(this.getClass().getClassLoader().getResource(fruitFile).toURI()))) {
            CsvToBeanBuilder<Fruit> builder = new CsvToBeanBuilder<>(reader);
            builder.withType(Fruit.class);
            List<Fruit> fruits = builder.build().parse();
            fruitRepository.saveAll(fruits);
        }
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
    } */
}