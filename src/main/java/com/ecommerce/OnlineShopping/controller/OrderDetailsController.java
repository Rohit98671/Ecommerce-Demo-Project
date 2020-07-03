package com.ecommerce.OnlineShopping.controller;

import com.ecommerce.OnlineShopping.domain.OrderDetails;
import com.ecommerce.OnlineShopping.domain.Product;
import com.ecommerce.OnlineShopping.domain.Users;
import com.ecommerce.OnlineShopping.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping
public class OrderDetailsController {

    @Autowired
    private OrderDetailsService orderDetailsService;

//    @GetMapping("orders")
//    public String orderDetailsPage() {
//
//        return "redirect:pay";
//    }

    @GetMapping("listOrders")
    public String orderListPage(Model model) {
        List<OrderDetails> allOrders = orderDetailsService.findAllOrders();
        model.addAttribute("orderDetails", allOrders);
        return "admin/order-details-list";
    }

//    @GetMapping
//    public String listOrders(Model model, HttpSession session){
//        Users user = (Users)session.getAttribute("user");
//        List<Product> products =  orderDetailsService.productIn(user.getUsername());
//        model.addAttribute("products", products);
//        model.addAttribute("total", orderDetailsService.totalSum(user.getUsername()));
//        return "loggedIn/order-details";
//    }

//    @GetMapping("removeFromOrders")
//    public String removeFromOrders(@RequestParam("id") Long id) {
//
//        orderDetailsService.removeProductFromOrders(id);
//
//        return "redirect:carts";
//    }
//    @GetMapping("saveToOrder")
//    public String addToOrder (@RequestParam("prodId") Long prodId, HttpSession session,
//                             @RequestParam("prodPrice") BigDecimal prodPrice) {
//        OrderDetails orderDetails = new OrderDetails();
//        orderDetails.setProdid(prodId);
//        orderDetails.setProdprice(prodPrice);
//        Users user = (Users)session.getAttribute("user");
//
//        orderDetails.setUsername(user.getUsername());
//
//        orderService.addToOrder(orderDetails);
//
//        return "redirect:shop";
//    }

//    @GetMapping("toOrders")
//    public String listOrders(String username, HttpSession session, Model model){
//        Users users = (Users)session.getAttribute("users");
//        List<Product> products = orderService.productIn(users.getUsername());
//        model.addAttribute("products", products);
//
//        return "loggedIn/order-details";
//
//    }

//    @GetMapping("saveToOrder")
//    public String addToOrder(@RequestParam("cartId") Long id, HttpSession session) {
//        OrderDetails orderDetails = new OrderDetails();
//        orderDetails.setCartid(id);
//
//        Users users = (Users)session.getAttribute("users");
//        orderDetails.setUsername(users.getUsername());
//
//        orderService.addToOrder(orderDetails);
//
//        return "redirect:payment";
//
//
//
//    }

}
