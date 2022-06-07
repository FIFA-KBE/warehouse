package com.kbe.warehouse.model;

import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;

@Entity
@Table(name = "Fruit")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer Id;

    @CsvBindByPosition(position = 0)
    @Column(name = "Name")
    private String Name;

    @CsvBindByPosition(position = 1)
    @Column(name = "Price")
    private Double Price;

    @CsvBindByPosition(position = 2)
    @Column(name = "Quantity")
    private Integer Quantity;

    @Column(name = "Availability")
    @CsvBindByPosition(position = 3)
    private Boolean Availability;

    public Fruit() {
        super();
    }

    public Fruit(String name, Double price, Integer quantity, Boolean availability) {
        super();
        Name = name;
        Price = price;
        Quantity = quantity;
        Availability = availability;
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

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Boolean getAvailability() {
        return Availability;
    }

    public void setAvailability(Boolean availability) {
        Availability = availability;
    }

}
