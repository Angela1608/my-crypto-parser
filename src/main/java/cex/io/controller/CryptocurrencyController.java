package cex.io.controller;

import cex.io.dto.ApiResponseDto;
import cex.io.repository.CryptocurrencyRepository;
import cex.io.service.HttpClient;
import cex.io.service.mapper.ApiResponseDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cryptocurrencies")
@AllArgsConstructor
public class CryptocurrencyController {
    private static final String LAST_PRICE_BTC_USD = "https://cex.io/api/last_price/BTC/USD";
    private static final String LAST_PRICE_ETH_USD = "https://cex.io/api/last_price/ETH/USD";
    private static final String LAST_PRICE_XRP_USD = "https://cex.io/api/last_price/XRP/USD";
    private final CryptocurrencyRepository repository;
    private final HttpClient httpClient;
    private final ApiResponseDtoMapper apiResponseDtoMapper;

    @Scheduled(fixedDelay = 10000)
    @PostMapping
    public void saveDatatoDb() {
        ApiResponseDto btcDto =
                httpClient.get(LAST_PRICE_BTC_USD, ApiResponseDto.class);
        ApiResponseDto ethDto =
                httpClient.get(LAST_PRICE_ETH_USD, ApiResponseDto.class);
        ApiResponseDto xrpDto =
                httpClient.get(LAST_PRICE_XRP_USD, ApiResponseDto.class);
        List<ApiResponseDto> cryptocurrenciesDto =
                List.of(btcDto, ethDto, xrpDto);
        cryptocurrenciesDto
                .stream()
                .map(apiResponseDtoMapper::toModel)
                .forEach(repository::save);
    }
}

