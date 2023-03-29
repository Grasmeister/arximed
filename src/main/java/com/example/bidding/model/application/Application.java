package com.example.bidding.model.application;

import com.example.bidding.enums.ApplicationStatusEnum;
import com.example.bidding.model.client.Customer;
import com.example.bidding.model.contract.ContractNew;
import com.example.bidding.model.employee.Employee;
import com.example.bidding.model.product.Specification;
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

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Application {

    @Id
    @GeneratedValue
    private int id;

    //Номер заявки
    @Column(name = "application_id")
    private long applicationId;

    //Начальная максимальная цена
    @Column(name = "initial_maximum_price")
    private double initialMaximumPrice;

    //Закупочная цена
    @Column(name = "purchase_price")
    private double purchasePrice;

    //Предмет закупки
    @Column(name = "product_purchase")
    private String productPurchase;

    //Дата окончания подачи заявки
    @Column(name = "application_deadline_date")
    private Timestamp applicationDeadlineDate;

//    //Дата окончание рассмотрения заявки
//    @Column(name = "end_date_of_application_consideration")
//    private Timestamp endDateOfApplicationConsideration;

    //Дата аукциона
    @Column(name = "auction_date")
    private Timestamp auctionDate;

    //Элетронная площадка
    @Column(name = "electronic_platform")
    private String electronicPlatform;

    //Статус заявки
    @Enumerated(EnumType.STRING)
    @Column(name = "application_status")
    private ApplicationStatusEnum applicationStatusEnum;

    //Причина отклонения заявки
    @Column(name = "reason_for_rejection_of_application")
    private String reasonForRejectionOfApplication;

    //Размер обеспечения заявки
    @Column(name = "amount_of_application_ensuring")
    private double amountOfApplicationEnsuring;

//    //Размер обеспечения контракта
//    @Column(name = "amount_of_contract_ensuring")
//    private double amountOfContractEnsuring;
//
//    //Размер обеспечение контракта перечисленные заказчику
//    @Column(name = "amount_of_contract_ensuring_listed_to_customer")
//    private double amountOfContractEnsuringListedToCustomer;

    // Победитель аукциона
    @Column(name = "auction_winner")
    private String auctionWinner;

    //Ссылка на общем диске
    @Column(name = "folder_on_disk")
    private String folderOnDisk;

    //Комментарии
    @Column(name = "comments")
    private String comments;

    //Менеджер
    @OneToOne
    private Employee employee;

    //Заказчик
    @OneToOne
    private Customer customer;

    //Контракт
    @OneToOne
    private ContractNew contractNew;

    //Спецификация к контракту
    @OneToOne
    private Specification specif;
}
