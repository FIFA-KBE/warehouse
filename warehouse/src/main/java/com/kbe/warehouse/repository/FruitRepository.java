package com.kbe.warehouse.repository;

import com.kbe.warehouse.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit,Integer> {
    @Query(value = "SELECT e FROM Fruit e")
    List<Fruit> findAllFruits();
}
