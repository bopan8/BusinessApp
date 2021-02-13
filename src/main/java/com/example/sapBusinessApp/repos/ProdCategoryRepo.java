package com.example.sapBusinessApp.repos;

import com.example.sapBusinessApp.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdCategoryRepo extends JpaRepository <ProductCategory, Integer> {
}
