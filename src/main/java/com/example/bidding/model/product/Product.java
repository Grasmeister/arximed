package com.example.bidding.model.product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

//    //Артикул
//    @Column(name = "articular")
//    private String articular;

    //техническое задание
    @Column(name = "technical_specification")
    private String technicalSpecification;

    // Ед. изм.
    @Column(name = "unit_of_measurement")
    private String unitOfMeasurement;

    //Кол-во
    @Column(name = "quantity")
    private int quantity;

    //Цена Закупки
    @Column(name = "purchase_price")
    private double purchasePrice;

    // Сумма Закупки
    @Column(name = "purchase_amount")
    private double purchaseAmount;

    // НДС
    @Column(name = "vat")
    private int vat;

    //Цена ПРОДАЖИ
    @Column(name = "sale_price")
    private double salePrice;

    // Сумма ПРОДАЖИ
    @Column(name = "sale_amount")
    private double saleAmount;

    // Дельта
    @Column(name = "delta")
    private double delta;

    // Производитель/ Страна происхождения ( Если требуется)
    @Column(name = "country_of_origin")
    private String countryOfOrigin;

    // Поставщик (Вписать ссылки на сайт. Так же в папке сохранять коммерческие предложения)
    @Column(name = "supplier")
    private String supplier;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="person_id")
//    private Specification specif;

}
