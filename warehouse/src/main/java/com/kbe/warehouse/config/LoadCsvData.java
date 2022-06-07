package com.kbe.warehouse.config;

import com.kbe.warehouse.model.Fruit;
import com.kbe.warehouse.repository.FruitRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Component
public class LoadCsvData implements ApplicationRunner {
    FruitRepository fruitRepository;

    @Autowired
    public LoadCsvData(FruitRepository fruitRepository) {
        super();
        this.fruitRepository = fruitRepository;
    }

    @Value("FruitsData.csv")
    private String fruitFile;

    @Override
    public void run(ApplicationArguments args) throws IOException, URISyntaxException {
        Reader reader = Files.newBufferedReader(Paths.get(ClassLoader.getSystemResource(fruitFile).toURI()));
        List<Fruit> beans = new CsvToBeanBuilder<Fruit>(reader).withType(Fruit.class)
                .build().parse();
        for (Fruit userDetails : beans) {
            fruitRepository.save(userDetails);
        }
    }

}