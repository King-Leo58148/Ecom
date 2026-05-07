package com.codewithlouis.ecom_project.repository;

import com.codewithlouis.ecom_project.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Integer> {
    List<Product> id(int id);
}
