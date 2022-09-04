package com.example.Warehouse.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "Id")
    private Integer Id;

    @CsvBindByPosition(position = 0)
    @Column(name = "TeamName")
    private String TeamName;

    @CsvBindByPosition(position = 1)
    @Column(name = "PlayerOne")
    private String playerOne;

    @CsvBindByPosition(position = 2)
    @Column(name = "PlayerTwo")
    private String playerTwo;

    @CsvBindByPosition(position = 3)
    @Column(name = "PlayerThree")
    private String playerThree;

    @CsvBindByPosition(position = 4)
    @Column(name = "PlayerFour")
    private String playerFour;

    @CsvBindByPosition(position = 5)
    @Column(name = "PlayerFive")
    private String playerFive;

    @CsvBindByPosition(position = 6)
    @Column(name = "PlayerSix")
    private String playerSix;

    @CsvBindByPosition(position = 7)
    @Column(name = "PlayerSeven")
    private String playerSeven;

    @CsvBindByPosition(position = 8)
    @Column(name = "PlayerEight")
    private String playerEight;

    @CsvBindByPosition(position = 9)
    @Column(name = "PlayerNine")
    private String playerNine;

    @CsvBindByPosition(position = 10)
    @Column(name = "PlayerTen")
    private String playerTen;

    @CsvBindByPosition(position = 11)
    @Column(name = "PlayerEleven")
    private String playerEleven;

}