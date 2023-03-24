package com.example.bidding.authorization;

import com.example.bidding.model.employee.Employee;
import com.example.bidding.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FrontendEmployeeService implements UserDetailsService {

    /**
     * Зависимость на бэкенд сервис.
     */
    @Autowired
    private EmployeeService employeeService;

//    /**
//     * Зависимость на бэкенд сервис.
//     */
//    @Autowired
//    private RoleService roleService;

    /**
     * Реализация метода поиска информации о пользователе.
     *
     * @param username
     * @return userDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        Employee employee1 = employeeService.loadEmployeeByLogin(username);

        if (employee1.getId() < 0) {
            throw new UsernameNotFoundException("user not found");
        }
//        Role role = roleService.getRoleByUserId(user.getId());

        return new UserDetailsId(
                employee1.getId(),
                employee1.getLogin(),
                employee1.getPassword(),
                employee1.getRoleEnum().name()
        );
    }
}
