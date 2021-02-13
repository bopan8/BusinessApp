package com.example.sapBusinessApp.services;


import com.example.sapBusinessApp.domain.Administrator;
import com.example.sapBusinessApp.repos.AdministratorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdministratorRepo administratorRepo;

    @Override
    public List<Administrator> getAllAdmins() {
        return administratorRepo.findAll();
    }

    @Override
    public void saveAdmin(Administrator administrator) {
        this.administratorRepo.save(administrator);
    }

    @Override
    public Administrator getAdminById(int id) {
        Optional<Administrator> optional = administratorRepo.findById(id);
        Administrator administrator = null;

        if(optional.isPresent()){
            administrator= optional.get();
        }
        else
        {
            throw new RuntimeException("Admin with id: " +id +" not found ");
        }
        return  administrator;
    }

    @Override
    public void deleteAdminById(int id) {
        this.administratorRepo.deleteById(id);
    }
}
