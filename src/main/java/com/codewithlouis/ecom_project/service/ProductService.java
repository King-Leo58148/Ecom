package com.codewithlouis.ecom_project.service;

import com.codewithlouis.ecom_project.model.Product;
import com.codewithlouis.ecom_project.repository.ProductRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public List<Product> getAllProducts(){
       return productRepo.findAll();

    }


    public void addProducts(Product product) {
        productRepo.save(product);
    }
    public void updateProducts(Product product) {
        productRepo.save(product);
    }
    public Product getProductById(int id){
        return productRepo.findById(id).orElse(null);
    }
    public void deleteProducts(int id){
        productRepo.deleteById(id);
    }
}
