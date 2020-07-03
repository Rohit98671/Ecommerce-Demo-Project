package com.ecommerce.OnlineShopping.controller;

import com.ecommerce.OnlineShopping.domain.Product;
import com.ecommerce.OnlineShopping.domain.TopSales;
import com.ecommerce.OnlineShopping.domain.Users;
import com.ecommerce.OnlineShopping.service.ProductService;
import com.ecommerce.OnlineShopping.service.SalesService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class LoginController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SalesService salesService;

    @GetMapping("home")
    public String productHome(Model model) {
        List<Product> allProducts = productService.findAllProducts();
        model.addAttribute("products", allProducts);
        return "index";
    }

    @GetMapping("indexSales")
    public String listPage(Model model) {
        List<TopSales> salesProducts = salesService.findAllProducts();
        model.addAttribute("sales", salesProducts);

        return "redirect:/home";
    }

    @GetMapping("loginHome")
    public String home(Model model, HttpSession session) {
        List<Product> allProducts = productService.findAllProducts();
        model.addAttribute("products", allProducts);

        Users users = (Users)session.getAttribute("users");
        session.setAttribute("users", users);

        return "loggedIn/index";
    }

    @GetMapping("shop")
    public String allProducts(Model model) {

        List<Product> allProducts = productService.findAllProducts();
        model.addAttribute("products", allProducts);
        return "loggedIn/shop";
    }


    @GetMapping("productDetails")
    public String productDetailPage(@RequestParam("id") Long id, Model model) {
        Product product = productService.getById(id);

        model.addAttribute("products", product);

        return "ProductDetail";
    }


    @GetMapping("about")
    public String AboutUs() {
        return "loggedIn/about";
    }

    @GetMapping("contact")
    public String ContactUs() {
        return "loggedIn/contact-us";
    }

    @GetMapping ("wishList")
    public String wishlist(){
        return "loggedIn/wishlist";
    }

    @GetMapping("checkout")
    public String payment(){
        return "loggedIn/payment";
    }
}


