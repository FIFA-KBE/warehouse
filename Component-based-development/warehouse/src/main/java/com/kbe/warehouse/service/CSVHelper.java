package com.kbe.warehouse.service;

import com.kbe.warehouse.model.Fruit;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVHelper {

    public static String type = "text/csv";
    static String[] header = {"Id", "Name", "Price", "Quantity",
            "Country of Origin", "Description", "Availability"};

    public static boolean hasCsvFormat(MultipartFile file) {

        if (!type.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public static List<Fruit> csvDataToFruits(InputStream inputStream) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Fruit> fruits = new ArrayList<Fruit>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Fruit fruit = new Fruit(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("Name"),
                        Double.parseDouble(csvRecord.get("Prize")),
                        Integer.parseInt(csvRecord.get("Quantity")),
                        csvRecord.get("Country of Origin"),
                        csvRecord.get("Description"),
                        Boolean.parseBoolean(csvRecord.get("Availability"))
                );
                fruits.add(fruit);
            }
            return fruits;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file" + e.getMessage());
        }
    }
}
