package cex.io.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CryptocurrencyResponseDto {
    private LocalDateTime createdAt;
    private String cryptocurrencyName;
    private String currencyName;
    private Double price;
}
