package com.customer.customer_service.entity;

import lombok.Data;

@Data
public class SearchParam {

    private String category;
    private double price;
    private String productType;
    private String productName;
    
}
