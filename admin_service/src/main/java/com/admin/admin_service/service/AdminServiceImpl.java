package com.admin.admin_service.service;

import java.util.List;

import com.admin.admin_service.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    RestTemplate restTemplate;


    @Override
    public boolean addproduct(Product p) {
        
        return restTemplate.postForObject("http://PRODUCT-SERV/product/add", p, boolean.class);
    }

    @Override
    public boolean addManyproduct(List<Product> plist) {
        // TODO Auto-generated method stub
      return  restTemplate.postForObject("http://PRODUCT-SERV/product/addmany", plist, boolean.class);
    
    }

    @Override
    public boolean updateProduct(int id, Product product) {
        // TODO Auto-generated method stub

        try {
            restTemplate.put("http://PRODUCT-SERV/product/update/"+id, product,boolean.class);
            return true;

        } catch (Exception e) {
            return false;
        }
         
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        

         
        try {
            restTemplate.delete("http://PRODUCT-SERV/product/delete/"+id);
            return true;

        } catch (Exception e) {
            return false;
        }
     
    }

 
    
}
