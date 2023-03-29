package com.example.bidding.authorization;

import lombok.Getter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * Расширяем стандартный контейнер авторизированного клиента.
 */
@Getter
public class EmployeeDetailsId extends User {


    private final int employeeId;

    public EmployeeDetailsId(final int id, final String username, final String password, final String role) {
        super(username, password, AuthorityUtils.createAuthorityList(role));
        employeeId = id;
    }

}
