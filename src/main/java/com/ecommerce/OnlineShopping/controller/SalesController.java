package com.ecommerce.OnlineShopping.controller;

import com.ecommerce.OnlineShopping.domain.Product;
import com.ecommerce.OnlineShopping.domain.TopSales;
import com.ecommerce.OnlineShopping.mapper.TopSalesMapper;
import com.ecommerce.OnlineShopping.service.SalesService;
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
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("salesList")
    public String listPage(Model model) {
        List<TopSales> salesProducts = salesService.findAllProducts();
        model.addAttribute("sales", salesProducts);

        return "product/sales-list";
    }

    @GetMapping("addSales")
    public String addPage(Model model) {
        model.addAttribute("sales", new TopSales());

        return "product/sales-add";
    }

    @PostMapping("saveSales")
    public String saveProduct(TopSales sales, MultipartFile file) throws IOException {

        byte[] prodimg = file.getBytes();
        sales.setProdimg(prodimg);
        sales.setContenttype(file.getContentType());
        salesService.saveOrUpdate(sales);

        return "redirect:salesList";
    }

    @GetMapping("editSales")
    public String editPage(@RequestParam("id") Long id, Model model) {
        TopSales sales = salesService.getById(id);

        model.addAttribute("sales", sales);

        return "product/sales-add";
    }

    @GetMapping("deleteSales")
    public String deletePage(@RequestParam("id") Long id) {
        salesService.deleteProduct(id);

        return "redirect:salesList";
    }


    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) {
        TopSales sales = salesService.getById(id);
        byte[] image = sales.getProdimg();
        String contentType =sales.getContenttype();
        return ResponseEntity.ok().contentType(MediaType.valueOf(contentType)).body(image);
    }

}
