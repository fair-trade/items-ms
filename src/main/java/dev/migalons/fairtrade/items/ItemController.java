package dev.migalons.fairtrade.items;

import dev.migalons.fairtrade.items.persintence.Item;
import dev.migalons.fairtrade.items.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ItemController {

    private final ItemsService itemsService;

    @Autowired
    public ItemController(ItemsService itemsService) {
        this.itemsService = itemsService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getItems() {
        // Here you would typically fetch and return items from your database
        return ResponseEntity.ok(itemsService.getItems());
    }

    @PostMapping("/items")
    public ResponseEntity addItem(@RequestBody Item item) {
        itemsService.addItem(item);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(item.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}