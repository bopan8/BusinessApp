package com.example.sapBusinessApp.controllers;


import com.example.sapBusinessApp.domain.Companies;
import com.example.sapBusinessApp.domain.ProductCategory;
import com.example.sapBusinessApp.domain.Products;
import com.example.sapBusinessApp.services.CategoriesService;
import com.example.sapBusinessApp.services.CompaniesService;
import com.example.sapBusinessApp.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductsController {
    //creating method handler to display list of products (index.html)
    @Autowired
    private ProductsService productsService;

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private CompaniesService companiesService;

    @GetMapping("admin/dashboard/products")
    public String viewProductsPage(Model model){
        List<Products> listProducts = productsService.getAllProducts();
        model.addAttribute("listOfProducts", listProducts);
        return "products";
    }

    //form for post data about product into database
    @GetMapping("admin/dashboard/showNewProduct")
    public String showNewProduct(Model model){
        List<ProductCategory> listOfCategories = categoriesService.getAllCategories();
        List<Companies> listOfCompanies = companiesService.getAllCompanies();
        Products products = new Products();
        model.addAttribute("products", products);
        model.addAttribute("listOfCategories", listOfCategories);
        model.addAttribute("listOfCompanies",listOfCompanies);
        return "new_product";
    }

    //save the data in the database
    @RequestMapping (value = "admin/dashboard/showFormForUpdateProduct/saveProduct",method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("products") Products products){
        productsService.saveProduct(products);
        return "redirect:/admin/dashboard/products";
    }

    @GetMapping("admin/dashboard/showFormForUpdateProduct/{productId}")
    public String showFormForUpdateProduct(@PathVariable("productId") int productId, Model model){
        Products products = productsService.getProductById(productId);
        List<ProductCategory> listOfCategories = categoriesService.getAllCategories();
        List<Companies> listOfCompanies = companiesService.getAllCompanies();
        model.addAttribute("products", products);
        model.addAttribute("listOfCategories", listOfCategories);
        model.addAttribute("listOfCompanies",listOfCompanies);
        return "update_product";
    }

    @GetMapping("admin/dashboard/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId") int productId){
        this.productsService.deleteProductById(productId);
        return "redirect:/admin/dashboard/products";
    }
}
