package com.example.bidding.repository;

import com.example.bidding.model.contract.ContractNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContractNewEntityRepository extends JpaRepository<ContractNew, Integer> {
}
