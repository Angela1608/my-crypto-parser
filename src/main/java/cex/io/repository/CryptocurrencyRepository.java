package cex.io.repository;

import cex.io.model.Cryptocurrency;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CryptocurrencyRepository extends MongoRepository<Cryptocurrency, String> {
    Cryptocurrency findFirstByCryptocurrencyNameOrderByPriceAsc(String cryptocurrencyName);

    Cryptocurrency findFirstByCryptocurrencyNameOrderByPriceDesc(String cryptocurrencyName);

    List<Cryptocurrency> findAllByCryptocurrencyName(String cryptocurrencyName, Pageable pageable);
}
