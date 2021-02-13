package com.example.sapBusinessApp.services;

import com.example.sapBusinessApp.domain.Companies;

import java.util.List;

public interface CompaniesService {
    List<Companies> getAllCompanies();
    void saveCompany(Companies companies);
    Companies getCompanyById(int id);
    void deleteCompany(int id);
}
