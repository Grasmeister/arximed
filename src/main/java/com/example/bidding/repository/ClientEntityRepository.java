package com.example.bidding.repository;

import com.example.bidding.model.client.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientEntityRepository extends JpaRepository<Client, Integer> {
}
