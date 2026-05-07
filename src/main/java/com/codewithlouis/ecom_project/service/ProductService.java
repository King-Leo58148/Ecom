package com.codewithlouis.ecom_project.service;

import com.codewithlouis.ecom_project.model.Product;
import com.codewithlouis.ecom_project.repository.ProductRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public List<Product> getAllProducts(){
       return productRepo.findAll();

    }


    public Product addProducts(Product product, MultipartFile imageFile) throws Exception
    {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return productRepo.save(product);

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
