package com.example.bidding.model.contract;

import com.example.bidding.enums.StatusEnum;
import com.example.bidding.model.client.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import java.sql.Timestamp;

@Setter
@Getter
@NoArgsConstructor
//@Jacksonized
@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @SequenceGenerator(name = "user_seq", sequenceName = "users_id_sequence", allocationSize = 1)
    private int id;

    //Номер контаркта
    @Column(name = "contract_id")
    private long contractId;

    //Сумма контаркта
    @Column(name = "contract_amount")
    private long contractAmount;

    //Сумма закупки
    @Column(name = "purchase_amount")
    private long purchaseAmount;

    //Дата аукциона
    @Column(name = "date_auction")
    private Timestamp dateAuction;

    //Дата окончания контракта
    @Column(name = "contract_end_date")
    private Timestamp contractEndDate;

    //Статус заявки
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusEnum statusEnum;


    //Наименование клиента
    @OneToOne
//    @PrimaryKeyJoinColumn
//    @Column(name = "client_id")
    private Client client;

    //Ответственный менеджер
//    @OneToOne(fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn
////    @Column(name = "employee")
//    private Employee employee;


//    //Список товаров
//    @Column(name = "listOfProducts")
//    private List<Product> listOfProducts;


}
