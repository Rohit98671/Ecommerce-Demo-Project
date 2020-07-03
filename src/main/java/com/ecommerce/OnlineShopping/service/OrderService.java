package com.ecommerce.OnlineShopping.service;

import com.ecommerce.OnlineShopping.domain.*;
import com.ecommerce.OnlineShopping.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrdersMapper ordersMapper;

    public List<Orders> findAllOrder() {
        return ordersMapper.selectByExample(new OrdersExample());
    }

    public Orders getById(Long id) {
        return ordersMapper.selectByPrimaryKey(id);
    }

    public void saveOrder(Orders orders) {
        if (orders.getOrdid() != null) {
            ordersMapper.updateByPrimaryKey(orders);
        }else {
            ordersMapper.insert(orders);
        }
    }

}
