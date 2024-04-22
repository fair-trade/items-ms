package dev.migalons.fairtrade.items.services;

import dev.migalons.fairtrade.items.config.ItemsRepository;
import dev.migalons.fairtrade.items.persintence.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemsService {

    private final ItemsRepository itemsRepository;

    @Autowired
    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public List<Item> getItems() {
        // Here you would typically fetch and return items from your database
        return (List<Item>) itemsRepository.findAll();
    }

    public void addItem(Item item) {
        item.setId(UUID.randomUUID());
        itemsRepository.save(item);
    }
}
