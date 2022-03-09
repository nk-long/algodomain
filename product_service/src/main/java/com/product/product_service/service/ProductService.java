package com.product.product_service.service;

import java.util.List;

import com.product.product_service.Entity.Product;
import com.product.product_service.Entity.SearchParam;

public interface ProductService {

    public List<Product> getProduct(SearchParam searchParam);

    public boolean addProduct(Product p);

    public List<Product> addMnayProduct(List<Product> productList);

    public Product updateProduct(int id, Product product);

    public String delete(int id);

    public List<Product> findByCat(String s);

    public Product getByName(String s);

    public List<Product> getByproductType(String s);



    
}
