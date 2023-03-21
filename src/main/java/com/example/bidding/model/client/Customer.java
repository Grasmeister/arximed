package com.example.bidding.model.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int id;

    //    Наименование заказчика
    @Column(name = "name_customer")
    private String nameCustomer;

    //    ИНН заказчика
    @Column(name = "inn_customer")
    private long innCustomer;

    //    Город заказчика
    @Column(name = "city_customer")
    private String cityCustomer;

}
