package com.ecommerce.OnlineShopping.service;

import com.ecommerce.OnlineShopping.domain.Message;
import com.ecommerce.OnlineShopping.domain.MessageExample;
import com.ecommerce.OnlineShopping.domain.Product;
import com.ecommerce.OnlineShopping.domain.ProductExample;
import com.ecommerce.OnlineShopping.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageMapper messageMapper;

    public List<Message> findAllMessages() {
        return messageMapper.selectByExample(new MessageExample());
    }

    public void sendMessage(Message message) {

            messageMapper.insert(message);
    }
}
