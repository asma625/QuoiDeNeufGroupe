package com.ecommerce.quoide9.dao;

import com.ecommerce.quoide9.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product WHERE p.productDescription LIKE %:search%")
    List <Product> findByProductDescriptionLikeString(@Param("search") String search);

}
