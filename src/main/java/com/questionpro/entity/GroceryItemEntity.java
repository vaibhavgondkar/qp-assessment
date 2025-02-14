package com.questionpro.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grocery_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroceryItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Long price;

    private int inventoryLevel;
}
