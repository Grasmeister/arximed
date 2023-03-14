package com.example.bidding.model.createForm;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateFormClient {

    // ООО, ИП, АО, ПАО и т.д.
    private String affiliation;

    // Название
    private String name;

    // ИНН
    private int inn;

    // КПП
    private int kpp;

    // Телефон
    private int phone;

    //Наименование Банка
    private String bankName;

    //БИК банка
    private int bankBik;

    //Кор счет банк
    private int bankCorAccount;

    //№ Счета в банка
    private int bankAccount;

    // Страна клиента
    private String addressCountry;

    // Город клиента
    private String addressCity;

    // Улица клиента
    private String addressStreet;

    // Номер дома клиента
    private int addressHouseNumber;

    // Номер офиса(кв., помещение) клиента
    private int addressOfficeNumber;
}

