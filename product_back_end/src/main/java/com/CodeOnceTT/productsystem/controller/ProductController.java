package com.CodeOnceTT.productsystem.controller;


import com.CodeOnceTT.productsystem.model.Product;
import com.CodeOnceTT.productsystem.repository.ProductRepository;
import com.CodeOnceTT.productsystem.service.ProductService;
import com.CodeOnceTT.productsystem.specifications.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;


    @PostMapping("/add")
    public String add(@RequestBody Product product){
        productService.saveProduct(product);
        return ("new product has been added!");
    }

    @GetMapping("/getAll")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    @GetMapping("/{productCategory}")
    public List<Product> findByCategoryName(@PathVariable("productCategory") String categoryName) {

        Specification<Product> specifications = Specification.where(ProductSpecification.hasCategoryName(categoryName).and(
                ProductSpecification.inStock()));

        return productRepository.findAll(specifications);

    }
}
