package com.example.sapBusinessApp.repos;

import com.example.sapBusinessApp.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends JpaRepository <Products, Integer> {
   // @Query(value = "SELECT * FROM business_app.products",nativeQuery = true)
   // List<Products> findAll();
}
