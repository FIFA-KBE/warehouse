package com.example.Warehouse.model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(generator = "increment")
    @Column(name = "Id")
    private Integer Id;

    @CsvBindByPosition(position = 0)
    @Column(name = "Name")
    private String Name;

    @CsvBindByPosition(position = 1)
    @Column(name = "firstName")
    private String FirstName;

    @CsvBindByPosition(position = 2)
    @Column(name = "Age")
    private Integer Age;

    @CsvBindByPosition(position = 3)
    @Column(name = "Position")
    private String Position;

    @CsvBindByPosition(position = 4)
    @Column(name = "Nationality")
    private String Nationality;

    @CsvBindByPosition(position = 5)
    @Column(name = "Cost")
    private Double Cost;

    @CsvBindByPosition(position = 6)
    @Column(name = "Rating")
    private Integer Rating;

    @CsvBindByPosition(position = 7)
    @Column(name = "imageURL")
    private String ImageURL;

    @CsvBindByPosition(position = 8)
    @Column(name = "Club")
    private String Club;

    @CsvBindByPosition(position = 9)
    @Column(name = "ClubCountry")
    private String ClubCountry;
}
