package com.kbe.warehouse.service;

import com.kbe.warehouse.model.Fruit;
import com.kbe.warehouse.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CSVService {
    @Autowired(required = false)
    FruitRepository fruitRepository;

    public void storeCSVDataToDatabase(MultipartFile file) {
        try {
            List<Fruit> fruits = CSVHelper.csvToFruits(file.getInputStream());
            fruitRepository.saveAll(fruits);
        } catch (IOException e) {
            throw new RuntimeException("fail to store CSV Data to Database: " + e.getMessage());
        }
    }

    public ByteArrayInputStream load() {
        List<Fruit> tutorials = fruitRepository.findAll();

        ByteArrayInputStream in = CSVHelper.fruitsToCSV(tutorials);
        return in;
    }

    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

}
