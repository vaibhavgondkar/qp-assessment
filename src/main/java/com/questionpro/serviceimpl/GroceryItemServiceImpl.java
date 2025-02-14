package com.questionpro.serviceimpl;

import com.questionpro.dto.GroceryItem;
import com.questionpro.entity.GroceryItemEntity;
import com.questionpro.repo.GroceryItemRepository;
import com.questionpro.service.GroceryItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryItemServiceImpl implements GroceryItemService {

    public static final Logger logger = LoggerFactory.getLogger(GroceryItemServiceImpl.class);

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Override
    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        try {
            logger.info("Adding new grocery item : {}", groceryItem.getName());
            GroceryItemEntity groceryItemEntity = new GroceryItemEntity();
            groceryItemEntity.setName(groceryItem.getName());
            groceryItemEntity.setPrice(groceryItem.getPrice());
            groceryItemEntity.setInventoryLevel(groceryItem.getInventoryLevel());
            groceryItemRepository.save(groceryItemEntity);
            groceryItem.setId(groceryItemEntity.getId());
            logger.info("Grocery item added successfully: {}", groceryItem.getName());
            return groceryItem;
        } catch (Exception e) {
            logger.error("Error adding grocery item: {}", groceryItem.getName(), e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<GroceryItem> getAllGroceryItems() {
        try {
            logger.info("Fetching all grocery items");
            List<GroceryItemEntity> groceryItemEntities = groceryItemRepository.findAll();
            return groceryItemEntities.stream().map(groceryItemEntity -> {
                GroceryItem groceryItem = new GroceryItem();
                groceryItem.setId(groceryItemEntity.getId());
                groceryItem.setName(groceryItemEntity.getName());
                groceryItem.setPrice(groceryItemEntity.getPrice());
                groceryItem.setInventoryLevel(groceryItemEntity.getInventoryLevel());
                return groceryItem;
            }).toList();
        } catch (Exception e) {
            logger.error("Error fetching grocery items", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String deleteGroceryItem(Long id) {
        try{
            logger.info("Inside delete grocery item by id : {}", id);
            groceryItemRepository.deleteById(id);
            return "grocery item with id : " + id + " deleted successfully";
        } catch (Exception e) {
            logger.error("Error deleting grocery item with id : {}", id);
            throw new RuntimeException(e);
        }
    }

    @Override
    public GroceryItem updateGroceryItem(Long id, GroceryItem groceryItem) {
        try{
            logger.info("Inside update grocery item by id : {}", id);
            GroceryItemEntity groceryItemEntity = groceryItemRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Grocery item not found with id : " + id));
            groceryItemEntity.setName(groceryItem.getName());
            groceryItemEntity.setPrice(groceryItem.getPrice());
            groceryItemEntity.setInventoryLevel(groceryItem.getInventoryLevel());
            groceryItemRepository.save(groceryItemEntity);
            return groceryItem;
        } catch (Exception e) {
            logger.error("Error updating grocery item with id : {}", id);
            throw new RuntimeException(e);
        }
    }

    @Override
    public GroceryItem updateInventory(Long id, int inventoryLevel) {
        try{
            logger.info("Inside update Inventory level for grocery item by id : {}", id);
            GroceryItemEntity groceryItemEntity = groceryItemRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Grocery item not found with id : " + id));
            groceryItemEntity.setInventoryLevel(inventoryLevel);
            groceryItemRepository.save(groceryItemEntity);
        } catch (Exception e) {
            logger.error("Error updating inventory for grocery item with id : {}", id);
            throw new RuntimeException(e);
        }
        return null;
    }


}
