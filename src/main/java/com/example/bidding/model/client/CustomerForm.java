package com.example.bidding.model.client;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomerForm { // Возможно и не потребуется

    //    Наименование заказчика
    private String nameCustomer;

    //    ИНН заказчика
    private long innCustomer;

    //    Город заказчика
    private String cityCustomer;
}
