package com.example.bidding.model.createForm;

import com.example.bidding.enums.ApplicationStatusEnum;
import com.example.bidding.enums.ContractStatusEnum;
import com.example.bidding.model.employee.Employee;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Getter
@Setter
public class CreateFormApplication {

    // Для парсинга даты.
    private static final DateFormat FORMAT;

    static {
        FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    }
// часть формы про заявкку

    //Номер заявки
    private long applicationId;

    //Начальная максимальная цена
    private double initialMaximumPrice;

    //Закупочная цена
    private double purchasePrice;

    //Предмет закупки
    private String productPurchase;

    // Информация по заказчику

    //    Наименование заказчика
    private String nameCustomer;

    //    ИНН заказчика
    private long innCustomer;

    //    Город заказчика
    private String cityCustomer;

    //Дата окончания подачи заявки
    private String applicationDeadlineDate;

    //Дата аукциона
    private String auctionDate;

    //Размер обеспечения заявки
    private double amountOfApplicationEnsuring;

    //Элетронная площадка
    private String electronicPlatform;


    //Ссылка на общем диске
    private String folderOnDisk;

    //Ответственный менеджер
    private Employee employee;

    //Комментарии
    private String comments;


    //Статус заявки
    private ApplicationStatusEnum applicationStatusEnum;

    //Причина отклонения заявки
    private String reasonForRejectionOfApplication;


    // Победитель аукциона
    private String auctionWinner;



    //Информация по контракту

    //Номер подписаного контракта
    private String numberOfSignedContract;

    //Дата подписания контракта
    private String dateOfContractSigning;

    //Цена контракта
    private double contractPrice;

    //Возврат обеспечения ( как обеспечели банковская гарантия или собственные средства или ничего или ) как занести
    private String ensuringRefund;

    //Срок поставки товара
    private int deliveryTimeOfProduct;

    //Срок исполнения контракта
    private String contractExecutionPeriod;

    //Место поставки товара
    private String placeOfDeliveryOfProduct;

    //Контактное лицо ФИО
    private String contactPerson;

    //Контактный телефон по контракту
    private long contactPhone;

    //Контактный Email по контракту
    private String contactEmail;

    //Размер обеспечения контракта
    private double amountOfContractEnsuring;

    //Размер обеспечение контракта перечисленные заказчику
    private double amountOfContractEnsuringListedToCustomer;

    //Услович поставки
    private String termsOfDelivery;


    //Cрок годности товара на момент поставки
    private String shelfLifeOfProductAtTimeOfDelivery;

    //Статус контракта
    private ContractStatusEnum contractStatusEnum;

    //Получение объекта календаря с временем посещения.
    @SneakyThrows
    public Timestamp getTime(String date) {
        if (date == null|| date.contains("")) {
            date = "1987-01-01 00:00:00";
            return Timestamp.valueOf(date);
        }

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return new Timestamp((df.parse(date)).getTime());
    }
}

