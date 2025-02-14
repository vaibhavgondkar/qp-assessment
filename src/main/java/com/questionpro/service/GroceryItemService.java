package com.questionpro.service;

import com.questionpro.dto.GroceryItem;

import java.util.List;

public interface GroceryItemService {

    GroceryItem addGroceryItem(GroceryItem groceryItem);

    List<GroceryItem> getAllGroceryItems();

    String deleteGroceryItem(Long id);

    GroceryItem updateGroceryItem(Long id, GroceryItem groceryItem);

    GroceryItem updateInventory(Long id, int inventoryLevel);
}
