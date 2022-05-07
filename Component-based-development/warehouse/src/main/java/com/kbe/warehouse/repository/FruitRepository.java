package com.kbe.warehouse.repository;

import com.kbe.warehouse.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    List<Fruit> findAllFruitsByName(String name);
}
