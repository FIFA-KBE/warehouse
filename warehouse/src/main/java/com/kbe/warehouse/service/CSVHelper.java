package com.kbe.warehouse.service;

import com.kbe.warehouse.model.Fruit;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
    public static String TYPE = "text/csv";
    static String[] HEADERs = { "Id", "Name", "Price", "Quantity", "Description", "Availability" };

    public static boolean hasCSVFormat(MultipartFile file) {
        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }
    public static List<Fruit> csvToFruits(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
            List<Fruit> fruits = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            for (CSVRecord csvRecord : csvRecords) {
                Fruit fruit = new Fruit(
                        Long.parseLong(csvRecord.get("Id")),
                        csvRecord.get("Name"),
                        Double.parseDouble(csvRecord.get("Price")),
                        Integer.parseInt(csvRecord.get("Quantity")),
                        csvRecord.get("Description"),
                        Boolean.parseBoolean(csvRecord.get("Availability"))
                );
                fruits.add(fruit);
            }
            return fruits;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }

    public static ByteArrayInputStream fruitsToCSV(List<Fruit> fruits) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
            for (Fruit fruit : fruits) {
                List<String> data = Arrays.asList(
                        String.valueOf(fruit.getId()),
                        fruit.getName(),
                        fruit.getDescription(),
                        String.valueOf(fruit.isAvailability())
                );

                csvPrinter.printRecord(data);
            }

            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
        }
    }
}
