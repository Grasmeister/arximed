package com.example.bidding.service;

import com.example.bidding.enums.RoleEnum;
import com.example.bidding.model.employee.Employee;
import com.example.bidding.model.employee.EmployeeForm;
import com.example.bidding.repository.EmployeeEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeEntityRepository employeeEntityRepository;

    public EmployeeService(EmployeeEntityRepository employeeEntityRepository) {
        this.employeeEntityRepository = employeeEntityRepository;
    }

//    public Employee getByLogin(String login) {
//
//        return employeeEntityRepository.getByLogin(login);
//    }

    public Employee findEmployeeByEmail(String email) {
        return employeeEntityRepository.findEmployeeByEmail(email);
    }

    public List<Employee> findAll() {
        return employeeEntityRepository.findAll();
    }

    public void createEmployee(EmployeeForm employeeForm) {

        Employee employee = new Employee();

        employee.setName(employeeForm.getName());
        employee.setPatronymic(employeeForm.getPatronymic());
        employee.setFamily(employeeForm.getFamily());
        employee.setRoleEnum(Arrays.asList(RoleEnum.values()).get(employeeForm.getRoleEnum().ordinal()));
        employee.setEmail(employeeForm.getLogin());

        employee.setPassword(employeeForm.getPassword());//Необходимо зашифромать пароль.

        employeeEntityRepository.save(employee);

    }
}
