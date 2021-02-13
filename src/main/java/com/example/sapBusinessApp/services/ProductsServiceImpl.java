package com.example.sapBusinessApp.services;

import com.example.sapBusinessApp.domain.Products;
import com.example.sapBusinessApp.repos.ProductsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService{

    @Autowired
    private ProductsRepo productsRepo;

    @Override
    public List<Products> getAllProducts() {
        return productsRepo.findAll();
    }

    @Override
    public void saveProduct(Products products) {
        this.productsRepo.save(products);
    }

    @Override
    public Products getProductById(int productId) {
        Optional<Products> optional = productsRepo.findById(productId);
        Products products = null;

        if(optional.isPresent()){
            products = optional.get();
        }
        else
        {
            throw new RuntimeException("Product with id: " +productId +" not found ");
        }
        return products;
    }

    @Override
    public void deleteProductById(int productId) {
        this.productsRepo.deleteById(productId);
    }
}
