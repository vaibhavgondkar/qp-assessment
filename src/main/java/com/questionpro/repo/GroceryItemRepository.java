package com.questionpro.repo;

import com.questionpro.entity.GroceryItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryItemRepository extends JpaRepository<GroceryItemEntity, Long> {

}
