package com.ecommerce.quoide9.controller;

import com.ecommerce.quoide9.dao.CustomerDao;
import com.ecommerce.quoide9.model.Country;
import com.ecommerce.quoide9.model.Customer;
import com.ecommerce.quoide9.view.CustomJsonView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {

    private CustomerDao customerDao;

    @Autowired
    public CustomerController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @GetMapping
    @JsonView({CustomJsonView.VueCustomer.class})
    public ResponseEntity<List<Customer>> getCountries() {
        return ResponseEntity.ok(customerDao.findAll());
    }
}
