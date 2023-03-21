package com.example.bidding.model.contract;

import com.example.bidding.enums.StatusEnum;
import com.example.bidding.model.client.Client;
import com.example.bidding.model.employee.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
//
//@Setter
//@Getter
//@NoArgsConstructor
////@Jacksonized
//@Entity
public class Contract {
//
//    @Id
//    @GeneratedValue
////    @SequenceGenerator(name = "user_seq", sequenceName = "users_id_sequence", allocationSize = 1)
//    private int id;
//
//    //Номер заявки
//    @Column(name = "contract_id")
//    private long contractId;
//
//    //Сумма контаркта
//    @Column(name = "contract_amount")
//    private long contractAmount;
//
//    //Сумма закупки
//    @Column(name = "purchase_amount")
//    private long purchaseAmount;
//
//    //Дата аукциона
//    @Column(name = "date_auction")
//    private Timestamp dateAuction;
//
//    //Дата окончания контракта
//    @Column(name = "contract_end_date")
//    private Timestamp contractEndDate;
//
//    //Статус заявки
//    @Enumerated(EnumType.STRING)
//    @Column(name = "status")
//    private StatusEnum statusEnum;
//
//
//    //Наименование клиента
//    @OneToOne
////    @PrimaryKeyJoinColumn
////    @Column(name = "client_id")
//    private Client client;
//
//    //    Ответственный менеджер
//    @OneToOne
////    @PrimaryKeyJoinColumn
////    @Column(name = "employee")
//    private Employee employee;


//    //Список товаров
//    @Column(name = "listOfProducts")
//    private List<Product> listOfProducts;
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
//

    //Статус заявки

}
