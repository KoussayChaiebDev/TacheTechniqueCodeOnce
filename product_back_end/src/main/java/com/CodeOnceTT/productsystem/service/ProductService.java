package com.CodeOnceTT.productsystem.service;

import com.CodeOnceTT.productsystem.model.Product;

import java.util.List;

public interface ProductService {

    public Product saveProduct(Product product);
    public List<Product> getAllProducts();
}
