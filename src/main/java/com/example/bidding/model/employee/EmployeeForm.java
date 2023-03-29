package com.example.bidding.model.employee;

import com.example.bidding.enums.RoleEnum;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EmployeeForm {


    //Имя
    private String name;

    //Фамилия
    private String family;

    //Отчество
    private String patronymic;

    //Должность
    private RoleEnum roleEnum;

    //Логин
    private String login;

    //Пароль
    private String password;

}
