package com.admin.admin_service.service;
import java.util.List;

import com.admin.admin_service.entity.Product;


public interface AdminService {

    public boolean addproduct(Product p);

    public boolean addManyproduct(List<Product> plist);

    public boolean updateProduct(int id, Product product);

    public boolean delete(int id);


}
