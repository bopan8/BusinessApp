package com.example.sapBusinessApp.repos;

import com.example.sapBusinessApp.domain.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepo extends JpaRepository <Customers, Integer> {
}
