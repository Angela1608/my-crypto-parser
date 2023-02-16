package cex.io.repository;

import cex.io.model.Cryptocurrency;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptocurrencyRepository extends MongoRepository<Cryptocurrency, String> {
}
