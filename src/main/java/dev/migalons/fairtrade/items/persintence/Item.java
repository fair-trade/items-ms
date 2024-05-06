package dev.migalons.fairtrade.items.persintence;

import jakarta.persistence.GeneratedValue;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class Item {
    @Id @GeneratedValue
    private UUID id;

    @NotNull
    private String name;

    private String description;

    @NotNull
    private Long amount;

    @NotNull
    private double price;

}
