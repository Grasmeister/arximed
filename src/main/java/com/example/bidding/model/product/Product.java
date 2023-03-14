package com.example.bidding.model.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity
//@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private int id;

    //Наименование
    @Column(name = "name")
    private String name;

    //Артикул
    @Column(name = "articular")
    private String articular;

    //Описание
    @Column(name = "description")
    private String description;

    //Кол-во
    @Column(name = "quantity")
    private int quantity;

    // Ед. изм.
    @Column(name = "unit_of_measurement")
    private String unitOfMeasurement;


}
