package com.kbe.warehouse.service;

import com.kbe.warehouse.model.Fruit;
import com.kbe.warehouse.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public class CSVService {

    @Autowired
    FruitRepository fruitRepository;

    public void storeCSVDataToDatabase(MultipartFile file) {
        try {
            List<Fruit> fruits = CSVHelper.csvDataToFruits(file.getInputStream());
            fruitRepository.saveAll(fruits);
        } catch (IOException e) {
            throw new RuntimeException("fail to store CSV Data to Database: " + e.getMessage());
        }
    }
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }
}
