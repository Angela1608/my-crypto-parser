package cex.io.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class CryptocurrencyResponseDto {
    private LocalDateTime createdAt;
    private String cryptocurrencyName;
    private String currencyName;
    private Double price;
}
