package com.kbe.warehouse.model;

import javax.persistence.*;

@Entity
@Table(name = "fruits")
public class Fruit {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "availability")
    private boolean availability;

    public Fruit() {
    }

    public Fruit(Long id, String name, Double price, Integer quantity, String description, boolean availability) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;;
        this.description = description;
        this.availability = availability;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Fruit [id=" + id + ", name=" + name + ", price=" + price +", quantity=" + quantity +
                ", desc=" + description + ", availability=" + availability + "]";
    }
}
