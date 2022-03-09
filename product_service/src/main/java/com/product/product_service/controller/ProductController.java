package com.product.product_service.controller;

import java.util.List;

import com.google.gson.Gson;
import com.product.product_service.Entity.Product;
import com.product.product_service.Entity.SearchParam;
import com.product.product_service.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/get/{data}")
    public List<Product> getProduct(@PathVariable(value = "data") String sParam)
    {
        Gson g = new Gson();
        SearchParam ss = g.fromJson(sParam, SearchParam.class);

        return service.getProduct(ss);
    }

    @PostMapping("/add")
    public boolean addProduct(@RequestBody Product pc)
    {
    //    Product p = pc.getProduct().stream().findFirst().get(); 
       return service.addProduct(pc);
    }

    @PostMapping("/addmany")
    public List<Product> addManProducts(@RequestBody List<Product> products ){
            return service.addMnayProduct(products);
    }


    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable(value = "id") int id, @RequestBody Product pro)
    {
        return service.updateProduct(id, pro);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id)
    {
        return service.delete(id);
    }

    @GetMapping("/getby/{category}")
    public List<Product> getBycategory(@PathVariable(value = "category") String category ){
            return service.findByCat(category);
    }

    @GetMapping("/gettype/{producttype}")
    public List<Product> getByProductType(@PathVariable(value = "producttype") String producttype ){
            return service.getByproductType(producttype);
    }
    @GetMapping("/getbyname/{name}")
    public Product getByName(@PathVariable(value = "name") String name ){
            return service.getByName(name);
    }


    
}
