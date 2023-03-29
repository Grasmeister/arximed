package com.example.bidding.model.product;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Getter
@Builder
public class CreateFormProduct {

    //Наименование
    private String name;

//    //Артикул
//    @Column(name = "articular")
//    private String articular;

    //техническое задание
    private String technicalSpecification;

    // Ед. изм.
    private String unitOfMeasurement;

    //Кол-во
    private int quantity;

    //Цена Закупки
    private double purchasePrice;

    // Сумма Закупки
    private double purchaseAmount;

    // НДС
    private int vat;

    //Цена ПРОДАЖИ
    private double salePrice;

    // Сумма ПРОДАЖИ
    private double saleAmount;

    // Дельта
    private double delta;

    // Производитель/ Страна происхождения ( Если требуется)
    private String countryOfOrigin;

    // Поставщик (Вписать ссылки на сайт. Так же в папке сохранять коммерческие предложения)
    private String supplier;

    private Specification specif;
}
