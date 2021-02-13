package com.example.sapBusinessApp.controllers;

import com.example.sapBusinessApp.domain.ProductCategory;
import com.example.sapBusinessApp.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("admin/dashboard/categories")
    public String viewCategories(Model model){
        model.addAttribute("listCategories", categoriesService.getAllCategories());
        return "categories";
    }

    @GetMapping("admin/dashboard/showNewCategory")
    public String showNewCategory(Model model){
        ProductCategory productCategory=new ProductCategory();
        model.addAttribute("productCategory", productCategory);
        return "new_category";
    }

    @RequestMapping( value = "admin/dashboard/showFormForUpdate/saveCategory",  method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("productCategory") ProductCategory productCategory){
        categoriesService.saveCategory(productCategory);
        return "redirect:/admin/dashboard/categories";
    }

    @GetMapping("admin/dashboard/showFormForUpdate/{categoryId}")
    public String showFormForUpdate(@PathVariable (value = "categoryId") int categoryId, Model model){
        //get category from the service
        ProductCategory productCategory = categoriesService.getCategoryById(categoryId);

        //set the category as a model attribute
        model.addAttribute("productCategory",productCategory);
        return "update_category";
    }

    @GetMapping("admin/dashboard/deleteCategory/{categoryId}")
    public String deleteCategory(@PathVariable (value = "categoryId") int categoryId){
        //call deleting method

        this.categoriesService.deleteCategoryById(categoryId);
        return "redirect:/admin/dashboard/categories";
    }
}
