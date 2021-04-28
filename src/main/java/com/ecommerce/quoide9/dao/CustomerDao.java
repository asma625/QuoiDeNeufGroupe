package com.ecommerce.quoide9.dao;

import com.ecommerce.quoide9.model.Country;
import com.ecommerce.quoide9.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
}
