package cex.io.service.mapper;

import cex.io.dto.ApiResponseDto;
import cex.io.dto.CryptocurrencyResponseDto;
import cex.io.model.Cryptocurrency;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class ResponseDtoMapper {
    public Cryptocurrency toModel(ApiResponseDto apiResponseDto) {
        Cryptocurrency cryptocurrency = new Cryptocurrency();
        cryptocurrency.setCreatedAt(LocalDateTime.now());
        cryptocurrency.setPrice(apiResponseDto.getLprice());
        cryptocurrency.setCryptocurrencyName(apiResponseDto.getCurr1());
        cryptocurrency.setCurrencyName(apiResponseDto.getCurr2());
        return cryptocurrency;
    }

    public CryptocurrencyResponseDto toDto(Cryptocurrency cryptoCurrency) {
        CryptocurrencyResponseDto responseDto = new CryptocurrencyResponseDto();
        responseDto.setCreatedAt(cryptoCurrency.getCreatedAt());
        responseDto.setCryptocurrencyName(cryptoCurrency.getCryptocurrencyName());
        responseDto.setCurrencyName(cryptoCurrency.getCurrencyName());
        responseDto.setPrice(cryptoCurrency.getPrice());
        return responseDto;
    }
}
