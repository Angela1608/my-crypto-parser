package cex.io.service;

import cex.io.model.Cryptocurrency;
import java.util.List;
import org.springframework.data.domain.PageRequest;

public interface CryptocurrencyService {
    void parseAndSave();

    Cryptocurrency getWithLowestPrice(String cryptocurrencyName);

    Cryptocurrency getWithHighestPrice(String cryptocurrencyName);

    List<Cryptocurrency> getAllByName(String cryptocurrencyName, PageRequest pageRequest);
}
