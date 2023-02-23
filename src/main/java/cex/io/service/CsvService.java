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
            = DateTimeFormatter.ofPattern("dd-MM-yy");
    private static final String FILE_PATH = "C:\\Users\\angel\\Downloads";
    private static final String BITCOIN = "BTC";
    private static final String ETHEREUM = "ETH";
    private static final String RIPPLE = "XRP";
    private final CryptocurrencyService service;

    public void createCSVReport() {
        String fileName = FILE_PATH + FORMATTER.format(LocalDateTime.now()) + ".csv";
        try (FileWriter writer = new FileWriter(fileName);
             CSVPrinter printer = new CSVPrinter(writer,
                     CSVFormat.DEFAULT.withHeader("Cryptocurrency Name", "Min Price", "Max Price"))) {
            printer.printRecord(BITCOIN, service.getWithLowestPrice(BITCOIN).getPrice(),
                    service.getWithHighestPrice(BITCOIN).getPrice());
            printer.printRecord(ETHEREUM, service.getWithLowestPrice(ETHEREUM).getPrice(),
                    service.getWithHighestPrice(ETHEREUM).getPrice());
            printer.printRecord(RIPPLE, service.getWithLowestPrice(RIPPLE).getPrice(),
                    service.getWithHighestPrice(RIPPLE).getPrice());
        } catch (IOException e) {
            throw new RuntimeException("Couldn't write the Csv report", e);
        }
    }
}
