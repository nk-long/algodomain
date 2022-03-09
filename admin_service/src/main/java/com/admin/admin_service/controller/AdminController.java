package com.admin.admin_service.controller;

import java.util.List;

import com.admin.admin_service.entity.Product;
import com.admin.admin_service.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService service;

    @PostMapping("/add")
    public Boolean addProduct(@RequestBody Product p)
    {
        return service.addproduct(p);
    }

    @PostMapping("/addmany")
    public Boolean addManyProduct(@RequestBody List<Product> p)
    {
        return service.addManyproduct(p);
    }
    
}
