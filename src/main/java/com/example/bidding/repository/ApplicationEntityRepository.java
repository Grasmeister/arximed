package com.example.bidding.repository;

import com.example.bidding.model.application.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationEntityRepository extends JpaRepository<Application, Integer> {

    Application findByApplicationId(long id);
}
