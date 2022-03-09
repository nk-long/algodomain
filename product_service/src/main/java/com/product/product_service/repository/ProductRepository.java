package com.product.product_service.repository;

import java.util.List;

import com.product.product_service.Entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
public List<Product> findByCategory(String s);

public Product findByName(String s);

public List<Product> findByproductType(String s);

    
}
