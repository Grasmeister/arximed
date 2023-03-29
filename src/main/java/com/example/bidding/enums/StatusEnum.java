package com.example.bidding.enums;

public enum StatusEnum {

    ZAPOLNENIE("Заполнение"),
    PODACHA("Подача"),
    ISPOLNENIE("Работа сзаявкой"),
    CLOSE("Выполнена"),
    OTKAZ("Отказ");

    private String frontName;

    StatusEnum() {
    }

    StatusEnum(String frontName) {
        this.frontName = frontName;
    }

    public String getFrontName() {
        return frontName;
    }
}
