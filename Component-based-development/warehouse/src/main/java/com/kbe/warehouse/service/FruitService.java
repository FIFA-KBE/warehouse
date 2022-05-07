package com.kbe.warehouse.service;

import com.kbe.warehouse.model.Fruit;
import com.kbe.warehouse.repository.FruitRepository;
import org.springframework.data.domain.Sort;

import java.util.List;

public class FruitService {

    private FruitRepository fruitRepository;

    private List<Fruit> listAllFruits() {
        return fruitRepository.findAll(Sort.by("name").ascending());
    }
}
