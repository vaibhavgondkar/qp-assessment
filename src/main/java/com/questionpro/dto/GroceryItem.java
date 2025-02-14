package com.questionpro.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroceryItem {
    private Long id;
    private String name;
    private Long price;
    private int inventoryLevel;

}
