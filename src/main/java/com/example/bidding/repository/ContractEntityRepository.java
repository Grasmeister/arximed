package com.example.bidding.repository;

import com.example.bidding.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractEntityRepository extends JpaRepository<Contract, Integer> {

}
