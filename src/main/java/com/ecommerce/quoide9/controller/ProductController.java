package com.ecommerce.quoide9.controller;


import com.ecommerce.quoide9.dao.ProductDao;
import com.ecommerce.quoide9.model.Country;
import com.ecommerce.quoide9.model.Product;
import com.ecommerce.quoide9.view.CustomJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/products")
public class ProductController {

    private ProductDao productDao;

    @Autowired
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping
    @JsonView({CustomJsonView.VueProduct.class})
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productDao.findAll());
    }
}
