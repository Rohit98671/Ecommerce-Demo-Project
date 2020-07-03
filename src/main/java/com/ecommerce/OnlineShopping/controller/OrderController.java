package com.ecommerce.OnlineShopping.controller;

import com.ecommerce.OnlineShopping.domain.*;
import com.ecommerce.OnlineShopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("ordersList")
    public String ordersListPage(Model model) {
        List<Orders> allOrders = orderService.findAllOrder();
        model.addAttribute("orders", allOrders);
        return "admin/order-list";
    }

    @GetMapping("addOrderInfo")
    public String addOrderInfo(Orders orders, Model model, HttpSession session) {
        Users users = (Users)session.getAttribute("users");
        orders.setUsername(users.getUsername());
        model.addAttribute("orders", new Orders());

        return "loggedIn/payment";
    }

    @PostMapping("saveOrder")
    public String saveOrder(Orders orders) {


        orderService.saveOrder(orders);

        return "redirect:editOrderInfo";
    }

    @GetMapping("editOrderInfo")
    public String editOrderInfo(@RequestParam("id") Long id, Model model){
        Orders orders = orderService.getById(id);
        model.addAttribute("orders", orders);
        return "redirect:addOrderInfo";
    }
}
