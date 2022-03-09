package com.seller.seller_service.service;

import java.util.Arrays;
import java.util.List;

import com.seller.seller_service.entity.Product;
import com.seller.seller_service.repository.SellerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class sellerServiceImpl implements SellerService{

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public Product addproduct(Product p) {
        
        return restTemplate.postForObject("http://PRODUCT-SERV/product/add", p, Product.class);
    }

    @Override
    public List<Product> addManyproduct(List<Product> plist) {
        // TODO Auto-generated method stub
       return Arrays.asList( restTemplate.postForObject("http://PRODUCT-SERV/product/addmany", plist, Product[].class) );
       
    }

    @Override
    public String updateProduct(int id, Product product) {
        // TODO Auto-generated method stub
         restTemplate.put("http://PRODUCT-SERV/product/update/"+id, product);

         return "sucess";

    }

    @Override
    public String delete(int id) {
        // TODO Auto-generated method stub
         restTemplate.delete("http://PRODUCT-SERV/product/delete/"+id);

         return "success";
     
    }

    @Override
    public List<Product> findByseller(int sellerId) {
        // TODO Auto-generated method stub
        return sellerRepository.findBysellerId(sellerId);
    }
    
}
