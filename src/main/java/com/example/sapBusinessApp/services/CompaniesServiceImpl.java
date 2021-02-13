package com.example.sapBusinessApp.services;

import com.example.sapBusinessApp.domain.Companies;
import com.example.sapBusinessApp.repos.CompaniesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompaniesServiceImpl implements  CompaniesService{
    @Autowired
    private CompaniesRepo companiesRepo;

    @Override
    public List<Companies> getAllCompanies() {
        return companiesRepo.findAll();
    }

    @Override
    public void saveCompany(Companies companies) {
        this.companiesRepo.save(companies);
    }

    @Override
    public Companies getCompanyById(int id) {
        Optional<Companies> optional = companiesRepo.findById(id);
        Companies companies = null;

        if(optional.isPresent()){
            companies= optional.get();
        }
        else{
            throw new RuntimeException("Company with id: " + id +" not found ");
        }
        return  companies;
    }

    @Override
    public void deleteCompany(int id) {
        this.companiesRepo.deleteById(id);
    }
}
