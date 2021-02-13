package com.example.sapBusinessApp.repos;

import com.example.sapBusinessApp.domain.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepo extends JpaRepository <Companies, Integer> {
}
