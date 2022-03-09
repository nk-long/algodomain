package com.customer.customer_service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "product_table")
public class Product {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String category;
    private String productType;
    private String name;
    private int ramSize;
    private String processor;
    private double displaySize;
    private double weight;
    private double price;
    private String color;
    private String material;
    private int size;
    private int sellerId;


    
}