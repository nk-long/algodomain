package com.customer.customer_service.controller;

import java.util.List;

import com.customer.customer_service.entity.Product;
import com.customer.customer_service.entity.SearchParam;
import com.customer.customer_service.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/customer")
public class customerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/get")
    public List<Product> getProduct(@RequestBody SearchParam sParam){
        return customerService.getProduct(sParam);
    }

    @GetMapping("/gettype/{producttype}")
    public List<Product> getByProductType(@PathVariable(value = "producttype") String producttype ){
            return customerService.getByproductType(producttype);
    }
    @GetMapping("/getbyname/{name}")
    public Product getByName(@PathVariable(value = "name") String name ){
            return customerService.getByName(name);
    }

    
}
