package com.kbe.warehouse.model;

import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;

@Entity
@Table(name = "Player")
public class Player {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Player() {
        super();
    }

    public Player(String name, String firstName, Integer age, String position,
                  String nationality, Double cost, Integer rating, String imageURL) {
        super();
        Name = name;
        FirstName = firstName;
        Age = age;
        Position = position;
        Nationality = nationality;
        Cost = cost;
        Rating = rating;
        ImageURL = imageURL;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFirstName() { return FirstName;}

    public void setFirstName(String firstName) { FirstName = firstName; }

    public Integer getAge() { return Age; }

    public void setAge(Integer age) { Age = age; }

    public String getPosition() { return Position; }

    public void setPosition(String position) { Position = position; }

    public String getNationality() { return Nationality; }

    public void setNationality(String nationality){ Nationality = nationality; }

    public Double getCost() { return Cost; }

    public void setCost(Double cost) { Cost = cost; }

    public Integer getRating() { return Rating; }

    public void setRating(Integer rating) { Rating = rating; }

    public String getImageURL() { return ImageURL; }

    public void setImageURL(String imageURL) { ImageURL = imageURL; }

}
