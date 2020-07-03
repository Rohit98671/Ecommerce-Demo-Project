package com.ecommerce.OnlineShopping.service;

import com.ecommerce.OnlineShopping.Exception.OutOfStockException;
import com.ecommerce.OnlineShopping.domain.*;
import com.ecommerce.OnlineShopping.mapper.ProductMapper;
import com.ecommerce.OnlineShopping.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ProductMapper productMapper;

    public List<Product> productInfo(String username) {
        List<Product> products = productMapper.getProductsByUsername(username);
        return products;
    }

    public BigDecimal totalPrice(String username) {
        return shoppingCartMapper.totalPrice(username);
    }

    public void removeProductFromCart(Long id) {
        shoppingCartMapper.removeFromCart(id);
    }


    public void addToCart(ShoppingCart shoppingCart){

        shoppingCartMapper.insert(shoppingCart);
    }

    public ShoppingCart cartClear(String username) {
        return shoppingCartMapper.clearCart(username);
    }



//    @Autowired
//    private ProductMapper productMapper;
//
//    private Map<Product, Integer> products = new HashMap<>();
//
//    public void addProduct(Product product) {
//        if (products.containsKey(product)) {
//            products.replace(product, products.get(product) + 1);
//        } else {
//            products.put(product, 1);
//        }
//    }

//    public void removeProduct(Product product) {
//        if (products.containsKey(product)) {
//            if (products.get(product) > 1)
//                products.replace(product, products.get(product) - 1);
//            else if (products.get(product) == 1) {
//                products.remove(product);
//            }
//        }
//    }
//
//    public Map<Product, Integer> getProductsInCart() {
//        return Collections.unmodifiableMap(products);
//    }

//    public void checkout() throws OutOfStockException {
//        Product product;
//        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
//            // Refresh quantity for every product before checking
//            product = productMapper.findOne(entry.getKey().getId());
//            if (product.getQuantity() < entry.getValue())
//                throw new OutOfStockException(product);
//            entry.getKey().setQuantity(product.getQuantity() - entry.getValue());
//        }
//        productMapper.save(products.keySet());
//        productMapper.flush();
//        products.clear();
//    }

//    public BigDecimal getTotal() {
//        return products.entrySet().stream()
//                .map(entry -> entry.getKey().getProdprice().multiply(BigDecimal.valueOf(entry.getValue())))
//                .reduce(BigDecimal::add)
//                .orElse(BigDecimal.ZERO);
//    }
}
