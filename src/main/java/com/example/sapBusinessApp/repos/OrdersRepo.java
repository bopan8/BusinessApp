package com.example.sapBusinessApp.repos;

import com.example.sapBusinessApp.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepo extends JpaRepository <Orders, Integer> {
}
