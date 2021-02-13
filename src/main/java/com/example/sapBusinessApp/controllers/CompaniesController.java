package com.example.sapBusinessApp.controllers;

import com.example.sapBusinessApp.domain.Companies;
import com.example.sapBusinessApp.domain.ProductCategory;
import com.example.sapBusinessApp.services.CategoriesService;
import com.example.sapBusinessApp.services.CompaniesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CompaniesController {

    @Autowired
    private CompaniesService companiesService;

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("admin/dashboard/companies")
    public String viewCompanies(Model model){
        model.addAttribute("companiesList", companiesService.getAllCompanies());
        return "companies";
    }

    @GetMapping("admin/dashboard/showNewCompany")
    public String showNewCompany(Model model){
        Companies companies = new Companies();
        List<ProductCategory> listOfCategories = categoriesService.getAllCategories();
        model.addAttribute("companies", companies);
        model.addAttribute("listOfCategories", listOfCategories);
        return "new_company";
    }

    @RequestMapping(value = "admin/dashboard/showFormForUpdateCompany/saveCompany",method = RequestMethod.POST)
    public String saveCompany(@ModelAttribute("companies") Companies companies){
        companiesService.saveCompany(companies);
        return "redirect:/admin/dashboard/companies";
    }

    @GetMapping("admin/dashboard/showFormForUpdateCompany/{id}")
    public String showFormForUpdateCompany(@PathVariable("id") int id, Model model){
        Companies companies = companiesService.getCompanyById(id);
        List<ProductCategory> listOfCategories = categoriesService.getAllCategories();
        model.addAttribute("companies", companies);
        model.addAttribute("listOfCategories", listOfCategories);
        return "update_company";
    }

    @GetMapping("admin/dashboard/deleteCompany/{id}")
    public String deleteCompany(@PathVariable("id") int id){
        this.companiesService.deleteCompany(id);
        return "redirect:/admin/dashboard/companies";
    }
}
