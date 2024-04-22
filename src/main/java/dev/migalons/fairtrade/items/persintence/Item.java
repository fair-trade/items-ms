package dev.migalons.fairtrade.items.persintence;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class Item {
    @Id
    private UUID id;

    private String name;

    private String description;

    private Long amount;

    private double price;

}
