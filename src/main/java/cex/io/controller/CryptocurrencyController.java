package cex.io.controller;

import cex.io.dto.CryptocurrencyResponseDto;
import cex.io.model.Cryptocurrency;
import cex.io.service.CryptocurrencyService;
import cex.io.service.CsvService;
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
    private final CsvService csvService;

    @GetMapping("/minprice")
    public CryptocurrencyResponseDto getByMinPrice(@RequestParam String name) {
        Cryptocurrency cryptocurrency = cryptoService.getWithLowestPrice(name.toUpperCase());
        return mapper.toDto(cryptocurrency);
    }

    @GetMapping("/maxprice")
    public CryptocurrencyResponseDto getByMaxPrice(@RequestParam String name) {
        Cryptocurrency cryptocurrency = cryptoService.getWithHighestPrice(name.toUpperCase());
        return mapper.toDto(cryptocurrency);
    }

    @GetMapping()
    public List<CryptocurrencyResponseDto> getAll(@RequestParam(defaultValue = "20") Integer size,
                                                  @RequestParam(defaultValue = "0") Integer page,
                                                  @RequestParam(defaultValue = "price") String sortBy,
                                                  @RequestParam String name) {
        Sort sort = Sort.by(sortBy);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return cryptoService
                .getAllByName(name, pageRequest)
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/csv")
    String getCsv() {
        csvService.createCSVReport();
        return "Csv report is successfully created!";
    }
}
