package cex.io.service;

import lombok.AllArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class CsvService {
    private final static DateTimeFormatter FORMATTER
            = DateTimeFormatter.ofPattern("dd-MM-yy_HH-mm-ss");
    private final CryptocurrencyService service;

    public void createCSVReport() {
        String fileName = "C:\\Users\\angel\\Downloads" + FORMATTER.format(LocalDateTime.now()) + ".csv";
        try (FileWriter writer = new FileWriter(fileName);
             CSVPrinter printer = new CSVPrinter(writer,
                     CSVFormat.DEFAULT.withHeader("Cryptocurrency Name", "Min Price", "Max Price"))) {
            printer.printRecord("BTC", service.getWithLowestPrice("BTC").getPrice(),
                    service.getWithHighestPrice("BTC").getPrice());
            printer.printRecord("ETH", service.getWithLowestPrice("ETH").getPrice(),
                    service.getWithHighestPrice("ETH").getPrice());
            printer.printRecord("XRP", service.getWithLowestPrice("XRP").getPrice(),
                    service.getWithHighestPrice("XRP").getPrice());
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write the Csv report", e);
        }
    }
}
