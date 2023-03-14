package com.example.bidding.model.employee;

import com.example.bidding.enums.RoleEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //Имя
    @Column(name = "name")
    private String name;

    //Фамилия
    @Column(name = "family")
    private String family;

    //Отчество
    @Column(name = "patronymic")
    private String patronymic;

    //Должность
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private RoleEnum roleEnum;
}
