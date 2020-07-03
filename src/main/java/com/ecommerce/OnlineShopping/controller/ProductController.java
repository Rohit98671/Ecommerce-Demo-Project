package com.ecommerce.OnlineShopping.controller;

import com.ecommerce.OnlineShopping.domain.Product;
import com.ecommerce.OnlineShopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("productHome")
    public String homePage(Model model) {
        List<Product> allProducts = productService.findAllProducts();
        model.addAttribute("products", allProducts);
        return "index";
    }

    @GetMapping("list")
    public String listPage(Model model) {
        List<Product> allProducts = productService.findAllProducts();
        model.addAttribute("products", allProducts);

        return "product/product-list";
    }

    @GetMapping("add")
    public String addPage(Model model) {
        model.addAttribute("products", new Product());

        return "product/product-add";
    }

    @GetMapping("details")
    public String findProductById(@RequestParam("id") Long id, Model model) {
        Product product = productService.getById(id);

        model.addAttribute("products", product);

        return "loggedIn/ProductDetail";
    }


    @PostMapping("saveProduct")
    public String saveProduct(Product product, MultipartFile file) throws IOException {

        byte[] prodimg = file.getBytes();
        product.setProdimg(prodimg);
        product.setContenttype(file.getContentType());

        productService.saveOrUpdate(product);

        return "redirect:list";
    }

    @GetMapping("edit")
    public String editPage(@RequestParam("id") Long id, Model model) {
        Product product = productService.getById(id);

        model.addAttribute("products", product);

        return "product/product-add";
    }

    @GetMapping("delete")
    public String deletePage(@RequestParam("id") Long id) {
        productService.deleteProduct(id);

        return "redirect:list";
    }

    @GetMapping("allProducts")
    public String allProducts(Model model) {
        List<Product> allProducts = productService.findAllProducts();
        model.addAttribute("products", allProducts);

        return "shop";
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
        Product product = productService.getById(id);
        byte[] image = product.getProdimg();
        String contentType =product.getContenttype();
        return ResponseEntity.ok().contentType(MediaType.valueOf(contentType)).body(image);
    }

//    public void getImage(HttpServletResponse response, @PathVariable("id") Long id) throws Exception {
//        response.setContentType("image/jpeg");
//
//        byte[] bytes =
//
//
//    }

}
