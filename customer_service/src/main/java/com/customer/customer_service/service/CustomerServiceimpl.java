package com.customer.customer_service.service;

import java.util.Arrays;
import java.util.List;

import com.customer.customer_service.entity.Product;
import com.customer.customer_service.entity.SearchParam;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerServiceimpl implements CustomerService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public List<Product> getProduct(SearchParam sParam) {

        System.out.println(sParam);
        String s =new Gson().toJson(sParam);

        Product p[] = restTemplate.getForObject("http://PRODUCT-SERV/product/get"+s, Product[].class);
        List<Product> lp = Arrays.asList(p);
        return lp;
    }

    @Override
    public List<Product> getbycat(String sParam) {
        // TODO Auto-generated method stub
        Product pp[] = restTemplate.getForObject("http://PRODUCT-SERV/product/getby/"+sParam, Product[].class);

       List<Product> p = Arrays.asList(pp);

       return p;
    }

    @Override
    public Product getByName(String s) {
        // TODO Auto-generated method stub
        return restTemplate.getForObject("http://PRODUCT-SERV/product/getbyname/"+s, Product.class);

    
    }

    @Override
    public List<Product> getByproductType(String s) {
        // TODO Auto-generated method stub
        Product pp[] = restTemplate.getForObject("http://PRODUCT-SERV/product/gettype/"+s, Product[].class);

        List<Product> p = Arrays.asList(pp);
 
        return p;
    }

  
}
