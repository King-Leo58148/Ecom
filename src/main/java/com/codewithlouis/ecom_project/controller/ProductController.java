package com.codewithlouis.ecom_project.controller;

import com.codewithlouis.ecom_project.model.Product;
import com.codewithlouis.ecom_project.repository.ProductRepo;
import com.codewithlouis.ecom_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseEntity<List<Product>>getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK) ;
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProducts(@PathVariable int id){
        Product product = productService.getProductById(id);
        if (product!=null)
       return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
        else
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@ModelAttribute Product product, @RequestPart MultipartFile imageFile){
         try {
             Product product1 = productService.addProducts(product, imageFile);
             return new ResponseEntity<>(product1,HttpStatus.CREATED);
         }
         catch (Exception e){
             return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
         }

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
