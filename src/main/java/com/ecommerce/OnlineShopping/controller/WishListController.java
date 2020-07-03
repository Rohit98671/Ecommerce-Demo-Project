package com.ecommerce.OnlineShopping.controller;

import com.ecommerce.OnlineShopping.domain.Product;
import com.ecommerce.OnlineShopping.domain.Users;
import com.ecommerce.OnlineShopping.domain.WishList;
import com.ecommerce.OnlineShopping.mapper.WishListMapper;
import com.ecommerce.OnlineShopping.service.ProductService;
import com.ecommerce.OnlineShopping.service.WishListService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @Autowired
    private ProductService productService;


    @GetMapping("wishlist")
    public String wishlist(Model model, HttpSession session){
        Users user = (Users)session.getAttribute("user");
        List<Product> products =  wishListService.wishListProduct(user.getUsername());
        model.addAttribute("products", products);
        return "loggedIn/wishlist";
    }

    @GetMapping("saveToWishlist")
    public String addToWishlist (@RequestParam("prodId") Long prodId, HttpSession session) {
        WishList wishList = new WishList();
        wishList.setProdid(prodId);
        Users user = (Users)session.getAttribute("user");

          wishList.setUsername(user.getUsername());

          wishListService.addToWishList(wishList);

          return "redirect:shop";
    }

    @GetMapping("salesToWishlist")
    public String addWishlist (@RequestParam("salesId") Long salesId, HttpSession session) {
        WishList wishList = new WishList();
        wishList.setSalesid(salesId);
        Users user = (Users)session.getAttribute("user");

        wishList.setUsername(user.getUsername());

        wishListService.addToWishList(wishList);

        return "loggedIn/wishlist";
    }

    //        byte[] prodimg = file.getBytes();
//        product.setProdimg(prodimg);
//        product.setContenttype(file.getContentType());

    @GetMapping("removeWishlist")
    public String removeFromWishlist(@RequestParam("id") Long id) {

        wishListService.removeWishlist(id);

        return "redirect:wishlist";
    }


}
