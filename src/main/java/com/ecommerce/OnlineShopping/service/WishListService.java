package com.ecommerce.OnlineShopping.service;

import com.ecommerce.OnlineShopping.domain.Product;
import com.ecommerce.OnlineShopping.domain.ProductExample;
import com.ecommerce.OnlineShopping.domain.WishList;
import com.ecommerce.OnlineShopping.domain.WishListExample;
import com.ecommerce.OnlineShopping.mapper.ProductMapper;
import com.ecommerce.OnlineShopping.mapper.WishListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService {

    @Autowired
    private WishListMapper wishListMapper;

    @Autowired
    private ProductMapper productMapper;

    public List<Product> wishListProduct(String username) {
        List<Product> products = productMapper.getProductsToWishList(username);
        return products;
    }

    public void removeWishlist(Long id) {
        wishListMapper.removeFromWishList(id);
    }

    public WishList getById(Long id) {

        return wishListMapper.selectByPrimaryKey(id);
    }

    public void addToWishList(WishList wishList){

        wishListMapper.insert(wishList);
    }

}
