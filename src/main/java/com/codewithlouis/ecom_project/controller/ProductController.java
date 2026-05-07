package com.codewithlouis.ecom_project.controller;

import com.codewithlouis.ecom_project.model.Product;
import com.codewithlouis.ecom_project.repository.ProductRepo;
import com.codewithlouis.ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
 @Autowired
 ProductService productService;

    @RequestMapping("/")
    public String great(){
        return "Welcome to Test Shopping";
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/products/{id}")
    public void getProducts(@PathVariable int id){
        productService.getProductById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
         productService.addProducts(product);
    }
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product){
        productService.updateProducts(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProducts(id);
    }
}
