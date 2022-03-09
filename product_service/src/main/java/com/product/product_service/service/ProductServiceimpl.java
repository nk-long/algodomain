package com.product.product_service.service;

import java.util.List;
import java.util.stream.Collectors;

import com.product.product_service.Entity.Product;
import com.product.product_service.Entity.SearchParam;
import com.product.product_service.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceimpl implements ProductService {


    @Autowired
    ProductRepository repository;


    @Override
    public boolean addProduct(Product p) {
        // TODO Auto-generated method stub
        Product pro = repository.save(p);
        if(pro!=null)
        {
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public List<Product> addMnayProduct(List<Product> productList) {
        // TODO Auto-generated method stub
        return repository.saveAll(productList);
    }

    @Override
    public Product updateProduct(int id, Product product) {
        // TODO Auto-generated method stub
        Product p = repository.findById(id).get();
        p.setPrice(product.getPrice());
        p.setName(product.getName());


        return repository.save(p);
    }

    @Override
    public String delete(int id) {
        // TODO Auto-generated method stub
         repository.deleteById(id);

         return "sucess";

    }

    @Override
    public List<Product> getProduct(SearchParam searchParam) {
        // TODO Auto-generated method stub
        List<Product> listp = repository.findAll();

        if(searchParam.getCategory()!=null)
        {
            return listp.stream().filter(x->x.getCategory().equalsIgnoreCase(searchParam.getCategory())).collect(Collectors.toList());
        }
        else if(searchParam.getProductType()!=null)
        {
            return listp.stream().filter(x->x.getProductType().equalsIgnoreCase(searchParam.getProductType())).collect(Collectors.toList());
        }
        else if(searchParam.getProductName()!=null)
        {
            return listp.stream().filter(x->x.getName().equalsIgnoreCase(searchParam.getProductName())).collect(Collectors.toList());
            
        }else if(searchParam.getPrice()!=0.0){
            return listp.stream().filter(x->x.getPrice()<searchParam.getPrice()).collect(Collectors.toList());
        }else{
            return null;
        }

        
        
    }

    @Override
    public List<Product> findByCat(String s) {
        
        // TODO Auto-generated method stub
        return repository.findByCategory(s);
    }

    @Override
    public Product getByName(String s) {
        // TODO Auto-generated method stub
        return repository.findByName(s);
    }

    @Override
    public List<Product> getByproductType(String s) {
        // TODO Auto-generated method stub
        return repository.findByproductType(s);
    }

    
    
}
