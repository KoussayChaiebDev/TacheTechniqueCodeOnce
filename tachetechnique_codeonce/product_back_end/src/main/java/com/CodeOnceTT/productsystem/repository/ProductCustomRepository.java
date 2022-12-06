package com.CodeOnceTT.productsystem.repository;

import com.CodeOnceTT.productsystem.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductCustomRepository {
    List<Product> findByCategory(String category);
}
