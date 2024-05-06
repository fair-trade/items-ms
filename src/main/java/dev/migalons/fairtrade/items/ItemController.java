package dev.migalons.fairtrade.items;

import dev.migalons.fairtrade.items.persintence.Item;
import dev.migalons.fairtrade.items.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
public class ItemController {

    private final ItemsService itemsService;

    @Autowired
    public ItemController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItems() {
         return ResponseEntity.ok(itemsService.getItems());
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItem(@PathVariable UUID id) {
        Item item = itemsService.getItem(id);
        if (item == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(item);
    }

    @PostMapping("/items")
    public ResponseEntity<Void> addItem(@RequestBody Item item) {
        itemsService.addItem(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable UUID id) {
        try {
            itemsService.deleteItem(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/items")
    public ResponseEntity<Void> updateItem(@RequestBody Item item) {
        try {
            itemsService.updateItem(item);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }

}