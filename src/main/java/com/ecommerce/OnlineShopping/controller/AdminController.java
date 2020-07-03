package com.ecommerce.OnlineShopping.controller;

import com.ecommerce.OnlineShopping.domain.Admin;
import com.ecommerce.OnlineShopping.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("adminLogin")
    public String adminLoginPage(Model model) {
        model.addAttribute("admin", new Admin());

        return "admin/admin-login";
    }

    @PostMapping("accessAdmin")
    public String loginAdmin(Admin admin, BindingResult adminLogin, HttpSession session) {
        Admin next = adminService.accessAdmin(admin.getUname(), admin.getPword());

        if (next == null){
            adminLogin.rejectValue("uname","You are not an Admin.");
        }

        if (adminLogin.hasErrors()){
            return "admin/login-error";
        }

//        session.setAttribute("user", next);

        return "product/product-list";

    }
}
