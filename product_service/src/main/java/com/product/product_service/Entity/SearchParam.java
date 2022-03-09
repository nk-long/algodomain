package com.product.product_service.Entity;

import lombok.Data;

@Data
public class SearchParam {

    private String category;
    private double price;
    private String productType;
    private String productName;
    
}
