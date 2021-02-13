package com.example.sapBusinessApp.services;

import com.example.sapBusinessApp.domain.ProductCategory;
import com.example.sapBusinessApp.repos.ProdCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriesServiceImpl implements CategoriesService{

    @Autowired
    private ProdCategoryRepo prodCategoryRepo;

    @Override
    public List<ProductCategory> getAllCategories() {
        return prodCategoryRepo.findAll();
    }

    @Override
    public void saveCategory(ProductCategory productCategory) {
        this.prodCategoryRepo.save(productCategory);
    }

    @Override
    public ProductCategory getCategoryById(int categoryId) {
        Optional<ProductCategory> optional = prodCategoryRepo.findById(categoryId);
        ProductCategory productCategory = null;

        if (optional.isPresent()){
            productCategory = optional.get();
        }
        else
        {
            throw new RuntimeException("Categories with id: " +categoryId +" not found ");
        }
        return  productCategory;
    }

    @Override
    public void deleteCategoryById(int categoryId) {
        this.prodCategoryRepo.deleteById(categoryId);
    }
}
