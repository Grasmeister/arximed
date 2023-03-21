package com.example.bidding.model.contract;

import com.example.bidding.enums.StatusEnum;
import com.example.bidding.model.client.Client;
import com.example.bidding.model.employee.Employee;
import lombok.Builder;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//@Getter
//@Builder
public class ContractForm {
//
//    private static final DateFormat FORMAT;
//
//    static {
//        FORMAT = new SimpleDateFormat("yyyy-MM-dd");
//    }
//
//    //Номер заявки
//    private int contractId;
//
//    //Начальная максимальная цена контракта
//    private long contractAmount;
//
//    //Сумма закупки
//    private int purchaseAmount;
//
//    //Дата аукциона
//    private String dateAuction;
//
//    //Дата окончания контракта
//    private String contractEndDate;
//
//    //Наименование клиента
//    private Client client;
//
//    //Статус заявки
//    private StatusEnum statusEnum;
//
//    //Получение объекта календаря с временем посещения.
//    @SneakyThrows
//    public Timestamp getTimeAuction() {
//        Date parsed = FORMAT.parse(dateAuction);
//        return new Timestamp(parsed.getTime());
//    }
//
//    @SneakyThrows
//    public Timestamp getTimeContractEnd() {
//        Date parsed = FORMAT.parse(contractEndDate);
//        return new Timestamp(parsed.getTime());
//    }
//
//    //Ответственный менеджер
//    private Employee employee;

//
//    //Дата подписания контракта
//    @Column(name = "date_of_contract_signing")
//    private Timestamp dateOfContractSigning;
//
//    //Номер подписаного контракта
//    @Column(name = "number_of_signed_contract")
//    private long numberOfSignedContract;
//
//    // Победитель аукциона
//    @Column(name = "auction_winner")
//    private String auctionWinner;
//
//    //Комментарии
//    @Column(name = "comments")
//    private String comments;
//
//    //Дата окончания заявки
//    @Column(name = "application_end_date")
//    private Timestamp applicationEndDate;
//
//    //Дата аукциона
//    @Column(name = "auction_date")
//    private Timestamp auctionDate;
//
//    //Элетронная площадка
//    @Column(name = "electronic_platform")
//    private String electronicPlatform;
//
//    //Размер обеспечения заявки
//    @Column(name = "amount_of_application_ensuring")
//    private long amountOfApplicationEnsuring;
//
//    //Размер обеспечения контракта
//    @Column(name = "amount_of_contract_ensuring")
//    private long amountOfContractEnsuring;
//
//    //Размер обеспечение контракта перечисленные заказчику
//    @Column(name = "amount_of_contract_ensuring_listed_to_customer")
//    private long amountOfContractEnsuringListedToCustomer;
//
//    //Возврат обеспечения
//    @Column(name = "ensuring_refund")
//    private String ensuringRefund;
//
//    //место поставки контракта
//    @Column(name = "place_of_delivery_of_contract")
//    private String placeOfDeliveryOfContract;
//
//    //Срок поставки товара
//    @Column(name = "delivery_time_of_product")
//    private int deliveryTimeOfProduct;
//
//    //Цена контракта
//    @Column(name = "contract_price")
//    private Long contractPrice;
//
//    //Процент понижения по контракту
//    @Column(name = "percentage_of_reduction_under_contract")
//    private long percentageOfReductionUnderContract;
//
//    //Контактное лицо
//    @Column(name = "contact_person")
//    private String contactPerson;
//
//    //Контактный телефон по контракту
//    @Column(name = "contact_phone")
//    private long contactPhone;
//
//    //Контактный Email по контракту
//    @Column(name = "contact_email")
//    private String contactEmail;
//
//    //Предмет закупки
//    @Column(name = "product_purchase")
//    private String productPurchase;
//
//    //Ссылка на общем диске
//    @Column(name = "folder_on_disk")
//    private String folderOnDisk;


//    //Список товаров
//    private List<Product> listOfProducts;
}
