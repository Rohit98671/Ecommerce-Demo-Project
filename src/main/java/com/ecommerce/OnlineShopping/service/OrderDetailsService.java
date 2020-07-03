package com.ecommerce.OnlineShopping.service;

import com.ecommerce.OnlineShopping.domain.*;
import com.ecommerce.OnlineShopping.mapper.OrderDetailsMapper;
import com.ecommerce.OnlineShopping.mapper.OrdersMapper;
import com.ecommerce.OnlineShopping.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    @Autowired
    private ProductMapper productMapper;

    public List<OrderDetails> findAllOrders() {
        return orderDetailsMapper.selectByExample(new OrderDetailsExample());
    }

    public List<Product> productIn(String username) {
        List<Product> products = productMapper.getProductsToOrderDetails(username);
        return products;
    }

    public BigDecimal totalSum(String username) {
        return orderDetailsMapper.totalSum(username);
    }

    public void removeProductFromOrders(Long id) {
        orderDetailsMapper.removeFromOrders(id);
    }

    public void addToOrder(OrderDetails orderDetails){

        orderDetailsMapper.insert(orderDetails);
    }
}
