package com.CodeOnceTT.productsystem.service;

import com.CodeOnceTT.productsystem.model.Product;
import com.CodeOnceTT.productsystem.model.Product_;
import com.CodeOnceTT.productsystem.repository.ProductCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class ProductCustomRepositoryImpl implements ProductCustomRepository {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Product> findByCategory(String category) {


        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();

        Root<Product> product = cq.from(Product.class);

        Predicate categoryNamePredicate = cb.equal(product.get(Product_.CATEGORY),category);

        cq.where(categoryNamePredicate);

        TypedQuery<Product> query = entityManager.createQuery(cq);

        return query.getResultList();



    }
}
