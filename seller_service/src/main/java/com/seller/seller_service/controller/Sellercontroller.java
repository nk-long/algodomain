package com.seller.seller_service.controller;

import java.util.List;

import com.seller.seller_service.entity.Product;
import com.seller.seller_service.service.SellerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
public class Sellercontroller {


    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product p)
    {
        return sellerService.addproduct(p);
    }

    @PostMapping("/addmany")
    public List<Product> addManyProduct(@RequestBody List<Product> p)
    {
        return sellerService.addManyproduct(p);
    }

    @GetMapping("/getbyseller/{id}")
    public List<Product> getBysellerId(@PathVariable(value = "id")int sellerId)
    {
            return sellerService.findByseller(sellerId);
    }

    
}
