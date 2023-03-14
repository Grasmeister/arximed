package com.example.bidding.repository;

import com.example.bidding.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEntityRepository extends JpaRepository<Product, Integer> {
}
