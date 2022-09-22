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
    @Column(name = "Owner")
    private String Owner;

    @CsvBindByPosition(position = 1)
    @Column(name = "TeamName")
    private String TeamName;

    @CsvBindByPosition(position = 2)
    @Column(name = "playerOne")
    private String playerOne;

    @CsvBindByPosition(position = 3)
    @Column(name = "playerTwo")
    private String playerTwo;

    @CsvBindByPosition(position = 4)
    @Column(name = "playerThree")
    private String playerThree;

    @CsvBindByPosition(position = 5)
    @Column(name = "playerFour")
    private String playerFour;

    @CsvBindByPosition(position = 6)
    @Column(name = "playerFive")
    private String playerFive;

    @CsvBindByPosition(position = 7)
    @Column(name = "playerSix")
    private String playerSix;

    @CsvBindByPosition(position = 8)
    @Column(name = "playerSeven")
    private String playerSeven;

    @CsvBindByPosition(position = 9)
    @Column(name = "playerEight")
    private String playerEight;

    @CsvBindByPosition(position = 10)
    @Column(name = "playerNine")
    private String playerNine;

    @CsvBindByPosition(position = 11)
    @Column(name = "playerTen")
    private String playerTen;

    @CsvBindByPosition(position = 12)
    @Column(name = "playerEleven")
    private String playerEleven;

}