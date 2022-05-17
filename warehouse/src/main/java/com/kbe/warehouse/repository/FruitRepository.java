package com.kbe.warehouse.repository;

import com.kbe.warehouse.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit,Integer> {
}
