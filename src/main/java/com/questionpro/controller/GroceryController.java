package com.questionpro.controller;

import com.questionpro.dto.GroceryItem;
import com.questionpro.dto.InventoryUpdateRequest;
import com.questionpro.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/groceries")
public class GroceryController {

    @Autowired
    private GroceryItemService groceryItemService;

    @PostMapping
    public ResponseEntity<GroceryItem> addGroceryItem(@RequestBody GroceryItem item) {
    return new ResponseEntity<>(groceryItemService.addGroceryItem(item), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
       return new ResponseEntity<>(groceryItemService.getAllGroceryItems(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGroceryItem(@PathVariable Long id) {
        return new ResponseEntity<>(groceryItemService.deleteGroceryItem(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        return new ResponseEntity<>(groceryItemService.updateGroceryItem(id, item), HttpStatus.OK);
    }

    @PatchMapping("/{id}/inventory")
    public ResponseEntity<GroceryItem> updateInventory(@PathVariable Long id, @RequestBody InventoryUpdateRequest request) {
        return new ResponseEntity<>(groceryItemService.updateInventory(id, request.getNewInventoryLevel()), HttpStatus.OK);
    }
}
