package cex.io.controller;

import cex.io.dto.CryptocurrencyResponseDto;
import cex.io.model.Cryptocurrency;
import cex.io.service.CryptocurrencyService;
import cex.io.service.mapper.ResponseDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cryptocurrencies")
@AllArgsConstructor
public class CryptocurrencyController {
    private final CryptocurrencyService cryptoService;
    private final ResponseDtoMapper mapper;

    @GetMapping("/max-price")
    public CryptocurrencyResponseDto getByMinPrice(@RequestParam String cryptocurrencyName) {
        Cryptocurrency cryptocurrency = cryptoService.getWithLowestPrice(cryptocurrencyName);
        return mapper.toDto(cryptocurrency);
    }

    @GetMapping("/min-price")
    public CryptocurrencyResponseDto getByMaxPrice(@RequestParam String cryptocurrencyName) {
        Cryptocurrency cryptocurrency = cryptoService.getWithHighestPrice(cryptocurrencyName);
        return mapper.toDto(cryptocurrency);
    }

    @GetMapping()
    public List<CryptocurrencyResponseDto> getAll(@RequestParam(defaultValue = "20") Integer count,
                                                  @RequestParam(defaultValue = "0") Integer page,
                                                  @RequestParam(defaultValue = "price") String sortBy,
                                                  @RequestParam String cryptocurrencyName) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, count, sort);
        return cryptoService
                .getAllByName(cryptocurrencyName, pageRequest)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
