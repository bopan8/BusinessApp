package com.example.sapBusinessApp.services;

import com.example.sapBusinessApp.domain.Products;

import java.util.List;

public interface ProductsService {
    List<Products> getAllProducts();
    void saveProduct(Products products);
    Products getProductById(int productId);
    void deleteProductById(int productId);
}
