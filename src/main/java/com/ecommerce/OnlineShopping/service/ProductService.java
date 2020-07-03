package com.ecommerce.OnlineShopping.service;

import com.ecommerce.OnlineShopping.domain.Product;
import com.ecommerce.OnlineShopping.domain.ProductExample;
import com.ecommerce.OnlineShopping.domain.WishList;
import com.ecommerce.OnlineShopping.mapper.ProductMapper;
import com.ecommerce.OnlineShopping.mapper.WishListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Blob;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public List<Product> findAllProducts() {
        return productMapper.selectByExample(new ProductExample());
    }

    public Product getById(Long id) {
        return productMapper.selectByPrimaryKey(id);
    }

    public void deleteProduct(Long id) {
        productMapper.deleteByPrimaryKey(id);
    }

    public void saveOrUpdate(Product product) {
        if (product.getProdid() != null) {
            productMapper.updateByPrimaryKey(product);
        } else {
            productMapper.insert(product);
        }
    }

    public byte[] getImageById(Long id){
        Product product = this.getById(id);
        if(product != null) {
            return product.getProdimg();
        }
        return new byte[]{};
    }

}

