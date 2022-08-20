package com.kbe.warehouse.model;

import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;
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
    @Column(name = "PlayerList")
    @ManyToMany
    @JoinTable(name = "Team_Player", joinColumns = @JoinColumn(name = "Team_Id"), inverseJoinColumns = @JoinColumn(name = "Player_Id"))
    private List<Player> PlayerList;

    @CsvBindByPosition(position = 2)
    @Column(name = "TotalVaule")
    private Double TotalVaule;

    @CsvBindByPosition(position = 3)
    @Column(name = "Owner")
    private String Owner;

    public Team() {
        super();
    }

    public Team(String teamName, List<Player> playerList, Double totalVaule, String owner) {
        super();
        TeamName = teamName;
        PlayerList = playerList;
        TotalVaule = totalVaule;
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
        return PlayerList;
    }

    public void setPlayerList(List<Player> playerList) {
        PlayerList = playerList;
    }

    public Double getTotalVaule() {
        return TotalVaule;
    }

    public void setTotalVaule(Double totalVaule) {
        TotalVaule = totalVaule;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    @Override
    public String toString() {
        return "Team [Id=" + Id + ", TeamName=" + TeamName + ", PlayerList=" + PlayerList + ", TotalVaule=" + TotalVaule + ", Owner=" + Owner + "]";
    }
}
