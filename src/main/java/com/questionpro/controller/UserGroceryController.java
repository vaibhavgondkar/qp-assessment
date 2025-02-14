package com.questionpro.controller;

import com.questionpro.dto.GroceryItem;
import com.questionpro.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groceries")
public class UserGroceryController {

    @Autowired
    private GroceryItemService groceryItemService;

    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllGroceryItems() {
        return new ResponseEntity<>(groceryItemService.getAllGroceryItems(), HttpStatus.OK);
    }

}
