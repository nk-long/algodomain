package com.customer.customer_service.service;

import java.util.List;

import com.customer.customer_service.entity.Product;
import com.customer.customer_service.entity.SearchParam;

public interface CustomerService {
    
    public List<Product> getProduct(SearchParam sParam);

    public List<Product> getbycat(String sParam);

    public Product getByName(String s);

    public List<Product> getByproductType(String s);
}
