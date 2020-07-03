package com.ecommerce.OnlineShopping.controller;

import com.ecommerce.OnlineShopping.domain.*;
import com.ecommerce.OnlineShopping.service.OrderDetailsService;
import com.ecommerce.OnlineShopping.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller

public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private OrderDetailsService orderDetailsService;
//
//    @GetMapping("p")
//    public String viewPrice(Model model, HttpSession session){
//        Users users = (Users)session.getAttribute("users");
//        model.addAttribute("total", shoppingCartService.totalPrice(users.getUsername()));
//
//        return "loggedIn/payment";
//    }


    @GetMapping("orders")
    public String orderDetails(Model model, HttpSession session){
        Users user = (Users)session.getAttribute("user");
        List<Product> products =  shoppingCartService.productInfo(user.getUsername());
        model.addAttribute("products", products);
        model.addAttribute("total", shoppingCartService.totalPrice(user.getUsername()));
        return "loggedIn/order-details";
    }

    @GetMapping("carts")
    public String cart(Model model, HttpSession session){
        Users user = (Users)session.getAttribute("user");
        List<Product> products =  shoppingCartService.productInfo(user.getUsername());
        model.addAttribute("products", products);
        model.addAttribute("total", shoppingCartService.totalPrice(user.getUsername()));
        return "loggedIn/cart";
    }

    @GetMapping("pay")
    public String afterPayment(HttpSession session) {
        Users user = (Users)session.getAttribute("user");
        shoppingCartService.cartClear(user.getUsername());

        return "loggedIn/thank-you";

    }

    @GetMapping("saveToCart")
    public String addToCart (@RequestParam("prodId") Long prodId, HttpSession session,
                             @RequestParam("prodPrice") BigDecimal prodPrice) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setProdid(prodId);
        shoppingCart.setProdprice(prodPrice);
        Users user = (Users)session.getAttribute("user");

        shoppingCart.setUsername(user.getUsername());

        shoppingCartService.addToCart(shoppingCart);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setProdid(prodId);
        orderDetails.setProdprice(prodPrice);

        orderDetails.setUsername(user.getUsername());
        orderDetails.setShpaddress(user.getAddress());
        orderDetails.setPhonenum(user.getContactnum());

        orderDetailsService.addToOrder(orderDetails);

        return "redirect:shop";
    }

    @GetMapping("removeFromCart")
    public String removeFromCart(@RequestParam("id") Long id) {

        shoppingCartService.removeProductFromCart(id);

        orderDetailsService.removeProductFromOrders(id);


        return "redirect:carts";
    }


//    @Autowired
//    private ProductService productService;
//
//    @GetMapping("/shopCart")
//    public String Cart(Model model) {
//
//        model.addAttribute("products", shoppingCartService.getProductsInCart());
//        model.addAttribute("total", shoppingCartService.getTotal().toString());
//        return "cart";
//    }

//    @GetMapping("/shoppingCart/addProduct/{productId}")
//    public String addProductToCart(@RequestParam("prodid") Long id) {
//        productService.getById(id).ifPresent(shoppingCartService::addProduct);
//        return shoppingCart();
//    }


    @GetMapping("cart")
    public String cart() {

        return "cart";
    }
}
