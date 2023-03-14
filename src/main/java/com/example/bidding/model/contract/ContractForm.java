package com.example.bidding.model.contract;

import com.example.bidding.enums.StatusEnum;
import com.example.bidding.model.client.Client;
import com.example.bidding.model.employee.Employee;
import lombok.Builder;
import lombok.Getter;
import lombok.SneakyThrows;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Getter
@Builder
public class ContractForm {

    private static final DateFormat FORMAT;

    static {
        FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    }

    //Номер контаркта
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
//    @SneakyThrows
//    public StatusEnum getStatus() {
//        System.out.println(statusEnum);
//
//        return StatusEnum.valueOf(statusEnum);
//    }

//    //Ответственный менеджер
//    private Employee employee;


//    //Список товаров
//    private List<Product> listOfProducts;
}
