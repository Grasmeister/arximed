package com.example.bidding.repository;

import com.example.bidding.model.client.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEntityRepository  extends JpaRepository<Customer, Integer> {
}
