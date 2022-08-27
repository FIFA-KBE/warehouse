package com.example.Warehouse.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Team")
public class Team {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @CsvBindByPosition(position = 0)
    @Column(name = "TeamName")
    private String TeamName;

    @ManyToMany
    @CsvBindByPosition(position = 1)
    @Column(name = "PlayerList")
    private List<Player> playerList;

}
