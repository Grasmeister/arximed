package com.example.bidding.model.contract;

import com.example.bidding.enums.ApplicationStatusEnum;
import com.example.bidding.enums.ContractStatusEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.SneakyThrows;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Setter
@Getter
@NoArgsConstructor
@Entity

@Table(name = "contract")
public class ContractNew {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    //Номер подписаного контракта
    @Column(name = "number_of_signed_contract")
    private String numberOfSignedContract;// = "-";

    //Дата подписания контракта
    @Column(name = "date_of_contract_signing")
    private Timestamp dateOfContractSigning;// = getTime();

    //Цена контракта
    @Column(name = "contract_price")
    private double contractPrice;// = 0.00;
//
//    //Возврат обеспечения
//    @Column(name = "ensuring_refund")
//    private String ensuringRefund;// = "-";

    //Срок поставки товара
    @Column(name = "delivery_time_of_product")
    private int deliveryTimeOfProduct;// = 0;

    //Срок исполнения контракта
    @Column(name = "contract_execution_period")
    private Timestamp contractExecutionPeriod;// = getTime();

    //Место поставки товара
    @Column(name = "place_of_delivery_of_product")
    private String placeOfDeliveryOfProduct;// = "-";

    //Контактное лицо ФИО
    @Column(name = "contact_person")
    private String contactPerson;//  = "-";

    //Контактный телефон по контракту
    @Column(name = "contact_phone")
    private long contactPhone;//  = 0L;

    //Контактный Email по контракту
    @Column(name = "contact_email")
    private String contactEmail;//  = "-";

    @SneakyThrows
    public Timestamp getTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return new Timestamp((df.parse("1900-01-01")).getTime());
    }

    //Размер обеспечения контракта
    @Column(name = "amount_of_contract_ensuring")
    private double amountOfContractEnsuring;

    //Размер обеспечение контракта перечисленные заказчику
    @Column(name = "amount_of_contract_ensuring_listed_to_customer")
    private double amountOfContractEnsuringListedToCustomer;

    //Статус контракта
    @Enumerated(EnumType.STRING)
    @Column(name = "contract_status")
    private ContractStatusEnum contractStatusEnum;

    //Услович поставки
    @Column(name="terms_of_delivery")
    private String termsOfDelivery;

    //Cрок годности товара на момент поставки
    @Column(name="shelf_life_of_product_at_time_of_delivery")
    private String shelfLifeOfProductAtTimeOfDelivery;

}
