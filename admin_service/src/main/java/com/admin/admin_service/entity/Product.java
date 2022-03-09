package com.admin.admin_service.entity;



import lombok.Data;

@Data
public class Product {
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