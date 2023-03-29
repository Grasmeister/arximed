package com.example.bidding.authorization;

import com.example.bidding.enums.RoleEnum;
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

        Employee employee = employeeService.findEmployeeByEmail(email);

//        String em = email;

//        Employee employee = new Employee();

//        employee.setName("Anton");
//        employee.setFamily("Taranenko");
//        employee.setPatronymic("Serg");
//        employee.setRoleEnum(RoleEnum.ROLE_ADMIN);
//        employee.setPassword("password");
//        employee.setEmail("ta@arxmed.ru");
//        employee.setId(1);

        return getEmployeeDetailsId(employee);

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
