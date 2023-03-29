package com.example.bidding.repository;

import com.example.bidding.model.product.Specification;
import liquibase.pro.packaged.R;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecificationRepository extends JpaRepository<Specification, Integer> {


}
