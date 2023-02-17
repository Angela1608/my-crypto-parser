package cex.io.repository;

import cex.io.model.Cryptocurrency;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CryptocurrencyRepository extends MongoRepository<Cryptocurrency, String> {
    Cryptocurrency findFirstByCryptoCurrencyNameOrderByPriceAsc(String cryptocurrencyName);

    Cryptocurrency findFirstByCryptoCurrencyOrderByPriceDesc(String cryptocurrencyName);

    List<Cryptocurrency> findAllByCryptoCurrencyName(String cryptocurrencyName, Pageable pageable);
}
