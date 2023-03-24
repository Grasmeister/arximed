package com.example.bidding.repository;

import com.example.bidding.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEntityRepository extends JpaRepository<Employee, Integer> {

    Employee loadEmployeeByLogin(String login);
}
