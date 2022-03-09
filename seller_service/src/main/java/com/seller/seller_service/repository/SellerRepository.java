package com.seller.seller_service.repository;

import java.util.List;

import com.seller.seller_service.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Product,Integer> {

    public List<Product> findBysellerId(int sellerId);
    
}
