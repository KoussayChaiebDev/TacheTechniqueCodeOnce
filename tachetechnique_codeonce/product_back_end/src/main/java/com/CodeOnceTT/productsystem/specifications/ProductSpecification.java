package com.CodeOnceTT.productsystem.specifications;

import com.CodeOnceTT.productsystem.model.Product;
import com.CodeOnceTT.productsystem.model.Product_;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


@Component
public class ProductSpecification {

    public static Specification<Product> hasCategoryName(String categoryName){
        return((root,criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.like(root.get(Product_.CATEGORY),"%" + categoryName + "%");
        });
    }

    public static Specification<Product> inStock(){
        return((root,criteriaQuery, criteriaBuilder) -> {
            return criteriaBuilder.greaterThan(root.get(Product_.STOCK),0);
        });
    }



}
