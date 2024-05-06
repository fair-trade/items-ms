package dev.migalons.fairtrade.items.services;

import dev.migalons.fairtrade.items.config.ItemsRepository;
import dev.migalons.fairtrade.items.persintence.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

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

    public Item getItem(UUID id) {
        return itemsRepository.findById(id).orElse(null);
    }

    public void addItem(@Validated @RequestBody Item item) {
        item.setId(UUID.randomUUID());
        itemsRepository.save(item);
    }

    public void deleteItem(UUID id) {
        itemsRepository.deleteById(id);
    }
    public void updateItem(Item item) {
        itemsRepository.save(item);
    }

    public void patchItem(@RequestBody @Validated Item item) {
        itemsRepository.save(item);
    }
}
