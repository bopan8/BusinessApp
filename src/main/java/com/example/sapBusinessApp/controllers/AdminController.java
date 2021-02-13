package com.example.sapBusinessApp.controllers;


import com.example.sapBusinessApp.domain.Administrator;
import com.example.sapBusinessApp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("admin/dashboard/admins")
    public String viewAdmins(Model model){
        model.addAttribute("adminList", adminService.getAllAdmins());
        return "admins";
    }

    @GetMapping("admin/dashboard/showNewAdmin")
    public String showNewAdmin(Model model){
        Administrator administrator = new Administrator();
        model.addAttribute("administrator", administrator);
        return "new_admin";
    }

    @RequestMapping(value = "admin/dashboard/showFormForUpdateAdmin/saveAdmin", method = RequestMethod.POST)
    public String saveAdmin(@ModelAttribute("administrator") Administrator administrator){
            adminService.saveAdmin(administrator);
        return "redirect:/admin/dashboard/admins";
    }

    @GetMapping("admin/dashboard/showFormForUpdateAdmin/{id}")
    public String showFormForUpdateAdmin(@PathVariable(value = "id") int id, Model model){
        Administrator administrator = adminService.getAdminById(id);

        model.addAttribute("administrator", administrator);
        return "update_admin";
    }

    @GetMapping("admin/dashboard/deleteAdmin/{id}")
    public String deleteAdmin(@PathVariable(value = "id") int id){
        this.adminService.deleteAdminById(id);
        return "redirect:/admin/dashboard/admins";
    }

    @RequestMapping("/admin/")
    public ModelAndView admin() {
        return new ModelAndView("admin_login");
    }

    @RequestMapping("/admin/login")
    public ModelAndView adminlogin() {
        return new ModelAndView("admin_login");
    }

    @RequestMapping("/admin/dashboard")
    public ModelAndView admindashboard() {
        return new ModelAndView("admin_dashboard");
    }
}
