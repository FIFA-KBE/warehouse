package com.kbe.warehouse.model;

import com.opencsv.bean.CsvBindAndSplitByName;
import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Team")
public class Team {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @CsvBindByPosition(position = 0)
    @Column(name = "TeamName")
    private String TeamName;

    @CsvBindByPosition(position = 1)
    @JoinTable(name = "Team_Player", joinColumns = @JoinColumn(name = "Team_Id"), inverseJoinColumns = @JoinColumn(name = "Player_Id"))
    @Column(name = "PlayerList")
    @ManyToMany
    private List<Player> playerList = new ArrayList<>();
    @CsvBindByPosition(position = 2)
    @Column(name = "Owner")
    private String Owner;

    public Team() {
        super();
    }

    public Team(String teamName, List<Player> playerList, String owner) {
        super();
        TeamName = teamName;
        playerList = playerList;
        Owner = owner;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        playerList = playerList;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    @Override
    public String toString() {
        return "Team{" +
                "Id=" + Id +
                ", TeamName='" + TeamName + '\'' +
                ", PlayerList=" + playerList +
                ", Owner='" + Owner + '\'' +
                '}';
    }
}
