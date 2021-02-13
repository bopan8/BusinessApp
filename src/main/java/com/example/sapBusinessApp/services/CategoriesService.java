package com.example.sapBusinessApp.services;

import com.example.sapBusinessApp.domain.ProductCategory;

import java.util.List;

public interface CategoriesService {
    List<ProductCategory> getAllCategories();
    void saveCategory(ProductCategory productCategory);
    ProductCategory getCategoryById(int categoryId);
    void deleteCategoryById(int categoryId);
}
