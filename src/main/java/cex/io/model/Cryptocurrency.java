package cex.io.model;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document
public class Cryptocurrency {
    @Id
    private String id;
    @Field
    private LocalDateTime createdAt;
    @Field
    private String cryptocurrencyName;
    @Field
    private String currencyName;
    @Field
    private Double price;
}
