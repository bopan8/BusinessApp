package com.example.sapBusinessApp.services;

import com.example.sapBusinessApp.domain.Administrator;

import java.util.List;

public interface AdminService {

    List<Administrator> getAllAdmins();
    void saveAdmin(Administrator administrator);
    Administrator getAdminById(int id);
    void deleteAdminById(int id);
}
