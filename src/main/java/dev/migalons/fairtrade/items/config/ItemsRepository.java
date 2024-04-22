package dev.migalons.fairtrade.items.config;

import dev.migalons.fairtrade.items.persintence.Item;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import java.util.UUID;

public interface ItemsRepository extends CouchbaseRepository<Item, UUID> {

}