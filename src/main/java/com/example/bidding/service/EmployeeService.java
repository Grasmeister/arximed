package com.example.bidding.service;

import com.example.bidding.model.employee.Employee;
import com.example.bidding.model.employee.EmployeeForm;
import com.example.bidding.repository.EmployeeEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeEntityRepository employeeEntityRepository;

    public List<Employee> findAll() {
        return employeeEntityRepository.findAll();
    }

    public Employee createEmployee(EmployeeForm employeeForm) {

        Employee employee = new Employee();
        employee.setName(employeeForm.getName());
        employee.setPatronymic(employeeForm.getPatronymic());
        employee.setFamily(employeeForm.getFamily());
        employee.setRoleEnum(employeeForm.getRoleEnum());

        employee = employeeEntityRepository.save(employee);

        return employee;
    }
}
