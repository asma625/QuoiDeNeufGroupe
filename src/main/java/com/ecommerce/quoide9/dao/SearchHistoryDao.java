package com.ecommerce.quoide9.dao;

import com.ecommerce.quoide9.model.SearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchHistoryDao extends JpaRepository<SearchHistory, Integer> {

}
