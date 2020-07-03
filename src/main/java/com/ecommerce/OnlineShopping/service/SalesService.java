package com.ecommerce.OnlineShopping.service;

import com.ecommerce.OnlineShopping.domain.Product;
import com.ecommerce.OnlineShopping.domain.ProductExample;
import com.ecommerce.OnlineShopping.domain.TopSales;
import com.ecommerce.OnlineShopping.domain.TopSalesExample;
import com.ecommerce.OnlineShopping.mapper.ProductMapper;
import com.ecommerce.OnlineShopping.mapper.TopSalesMapper;
import com.ecommerce.OnlineShopping.mapper.WishListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    private TopSalesMapper salesMapper;

    public List<TopSales> findAllProducts() {
        return salesMapper.selectByExample(new TopSalesExample());
    }

    public TopSales getById(Long id) {
        return salesMapper.selectByPrimaryKey(id);
    }

    public void deleteProduct(Long id) {
        salesMapper.deleteByPrimaryKey(id);
    }

    public void saveOrUpdate(TopSales sales) {
        if (sales.getSalesid() != null) {
            salesMapper.updateByPrimaryKey(sales);
        } else {
            salesMapper.insert(sales);
        }
    }
}
