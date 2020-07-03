package com.ecommerce.OnlineShopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class PaymentMethodController {
    @GetMapping("payment")
    public String payment(){
        return "loggedIn/payment";
    }
}
