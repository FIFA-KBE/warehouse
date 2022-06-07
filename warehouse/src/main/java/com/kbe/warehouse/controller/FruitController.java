package com.kbe.warehouse.controller;

import com.kbe.warehouse.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController {

    FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        super();
        this.fruitService = fruitService;
    }

    // Get All Employees Without Salary
    @GetMapping("/fruits")
    public ResponseEntity<?> allFruits() {
        return ResponseEntity.ok(fruitService.getAllFruits());
    }
}
