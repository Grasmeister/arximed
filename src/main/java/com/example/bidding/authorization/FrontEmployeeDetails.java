package com.example.bidding.authorization;

import com.example.bidding.model.employee.Employee;
import com.example.bidding.service.EmployeeService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class FrontEmployeeDetails implements UserDetailsService {

    private final EmployeeService employeeService;

    public FrontEmployeeDetails(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = employeeService.findEmployeeByEmail(email);

        return getEmployeeDetailsId(employee);
    }

    public UserDetails findEmployeeByEmail(String email) {
        return loadUserByUsername(email);
    }

    private EmployeeDetailsId getEmployeeDetailsId(Employee employee) {
        if (employee.getId() < 0) {
            throw new UsernameNotFoundException("user not found");
        }
        return new EmployeeDetailsId(
                employee.getId(),
                employee.getEmail(),
                employee.getPassword(),
                employee.getRoleEnum().name()
        );
    }
}
