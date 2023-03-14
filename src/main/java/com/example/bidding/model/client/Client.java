package com.example.bidding.model.client;


import com.example.bidding.model.contract.Contract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Setter
@Getter

@NoArgsConstructor
@Entity
public class Client {

    @Id
    @GeneratedValue
    private int id;

    // ООО, ИП, и т.д.
    @Column(name = "affiliation")
    private String affiliation;

    // Название
    @Column(name = "name")
    private String name;

    // ИНН
    @Column(name = "inn")
    private long inn;

    // КПП
    @Column(name = "kpp")
    private long kpp;

    // Телефон
    @Column(name = "phone")
    private long phone;

    //Наименование Банка
    @Column(name = "bank_name")
    private String bankName;

    //БИК банка
    @Column(name = "bank_bik")
    private int bankBik;

    //Кор счет банк
    @Column(name = "bank_cor_account")
    private long bankCorAccount;

    //№ Счета в банка
    @Column(name = "bank_account")
    private long bankAccount;

    // Страна клиента
    @Column(name = "address_country")
    private String addressCountry;

    // Город клиента
    @Column(name = "address_city")
    private String addressCity;

    // Улица клиента
    @Column(name = "address_street")
    private String addressStreet;

    // Номер дома клиента
    @Column(name = "address_house_number")
    private int addressHouseNumber;

    // Номер офиса(кв., помещение) клиента
    @Column(name = "address_office_number")
    private int addressOfficeNumber;

//    @OneToOne
//    private Contract contract;
    // Адрес клиента (связь один к одному)
//    @OneToOne(fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn
////    @Column(name = "clientAddress")
//    private ClientAddress clientAddress;

    //Счет клиент
    //связь один ко многим(один клиент несколько счетов)
//    @OneToOne
//    @PrimaryKeyJoinColumn
////    @Column(name= "clientAccount")
//    private ClientAccount clientAccount;
}
