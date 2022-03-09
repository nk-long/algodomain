package com.seller.seller_service.service;

import java.util.List;

import com.seller.seller_service.entity.Product;

public interface SellerService {

    public Product addproduct(Product p);

    public List<Product> addManyproduct(List<Product> plist);

    public String updateProduct(int id, Product product);

    public String delete(int id);

    public List<Product> findByseller(int sellerId);

}
