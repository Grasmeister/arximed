package com.example.bidding.model.createForm;

import com.example.bidding.enums.StatusEnum;
import com.example.bidding.model.client.Client;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
public class CreateFormContract {

    // Для парсинга даты.
    private static final DateFormat FORMAT;

    static {
        FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    }

    //Номер контаркта
    @NotNull
    private int contractId;

    //Сумма контаркта
    private long contractAmount;

    //Сумма закупки
    private int purchaseAmount;

    //Дата аукциона
    private String dateAuction;

    //Дата окончания контракта
    private String contractEndDate;

    //Наименование клиента
    private Client client;

    //Статус заявки
    private StatusEnum statusEnum;

    //        //Наименование клиента
//        private Client client;
//
//        //        Ответственный менеджер
//        private Employee employee;
//
//
//        //Список товаров
//        private List<Product> listOfProducts;
//
    //Получение объекта календаря с временем посещения.
    @SneakyThrows
    public Timestamp getTimeAuction() {
        Date parsed = FORMAT.parse(dateAuction);
        return new Timestamp(parsed.getTime());
    }

    @SneakyThrows
    public Timestamp getTimeContractEnd() {
        Date parsed = FORMAT.parse(contractEndDate);
        return new Timestamp(parsed.getTime());
    }
}

