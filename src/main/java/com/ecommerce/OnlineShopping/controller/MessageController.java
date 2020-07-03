package com.ecommerce.OnlineShopping.controller;

import com.ecommerce.OnlineShopping.domain.Message;
import com.ecommerce.OnlineShopping.domain.Product;
import com.ecommerce.OnlineShopping.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;


    @GetMapping("viewMessage")
    public String viewMessage(Model model) {
        List<Message> allMessages = messageService.findAllMessages();
        model.addAttribute("messages", allMessages);

        return "admin/msg-list";
    }

    @GetMapping("addMessage")
    public String addMessagePage(Model model) {
        model.addAttribute("messages", new Message());

        return "loggedIn/contact-us";
    }

    @PostMapping("sendMessage")
    public String sendMessagePage(Message message) {
        messageService.sendMessage(message);

        return "redirect:addMessage";
    }
}
