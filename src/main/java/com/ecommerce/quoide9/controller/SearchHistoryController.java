package com.ecommerce.quoide9.controller;

import com.ecommerce.quoide9.dao.CustomerDao;
import com.ecommerce.quoide9.dao.ProductDao;
import com.ecommerce.quoide9.dao.SearchHistoryDao;
import com.ecommerce.quoide9.model.Customer;
import com.ecommerce.quoide9.model.Product;
import com.ecommerce.quoide9.view.CustomJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchHistoryController {



        private SearchHistoryDao searchHistoryDao;
        private ProductDao productDao;

        @Autowired
        public SearchHistoryController (SearchHistoryDao searchHistoryDao , ProductDao productDao) {
            this.searchHistoryDao = searchHistoryDao;
            this.productDao =  productDao;
        }

        @PostMapping
        @JsonView({CustomJsonView.VueCustomer.class})
        public ResponseEntity<List<Product>> getProducts(@RequestBody String search) {
            return ResponseEntity.ok(productDao.findByProductDescriptionLikeString(search));
        }
    }