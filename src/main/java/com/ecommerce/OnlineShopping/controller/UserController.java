package com.ecommerce.OnlineShopping.controller;

import com.ecommerce.OnlineShopping.domain.Product;
import com.ecommerce.OnlineShopping.domain.Users;
import com.ecommerce.OnlineShopping.service.ProductService;
import com.ecommerce.OnlineShopping.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.awt.*;
import java.util.List;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

//    @GetMapping("home")
//    public String homePage() {
//        return "index";
//    }

    @GetMapping("registration")
    public String registrationPage(Model model) {
        model.addAttribute("user", new Users());

        return "customer/customer-register";
    }

    @PostMapping("save")
    public String addUser(Users users) {
        userService.saveOrUpdateUser(users);

        return "redirect:home";
    }

    @GetMapping("login")
    public String loginPage(Model model) {
        model.addAttribute("user", new Users());

        return "customer/customer-login";
    }

    @PostMapping("access")
    public String loginUser(Users users, BindingResult login, HttpSession session, Model model) {
        Users customer = userService.accessUser(users.getUsername(), users.getPassword());

        //Session & Cookie
        if (customer == null){
            login.rejectValue("username","Customer not registered");
        }

        if (login.hasErrors()){
            return "customer/customer-home";
        }
        List<Product> allProducts = productService.findAllProducts();
        model.addAttribute("products", allProducts);

        session.setAttribute("user", customer);

        return "loggedIn/notice";

    }

//    @GetMapping("myAccount")
//    public String userProfile(@RequestParam("username") String username) {
//
////        Users user = (Users)session.getAttribute("user");
//
//        userService.getByUsername(username);
//
//        return "loggedIn/UserProfile";
//    }

    @GetMapping("myAccount")
    public String userProfile(HttpSession session) {

        Users user = (Users)session.getAttribute("user");

        session.setAttribute("user", user);

        return "loggedIn/UserProfile";
    }

    @GetMapping("editAccount")
    public String editProfile(@RequestParam("username") String username, Model model) {
        Users users = userService.getByUsername(username);
        model.addAttribute("user", users);

        return "loggedIn/profile-edit";
    }

}
