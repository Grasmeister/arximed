package com.example.bidding.enums;

public enum RoleEnum {

    ROLE_ADMIN("Админ"),
    ROLE_MANAGER("Менеджер"),
    ROLE_DIRECTOR("Директор"),
    ROLE_PRODUCT_MANAGER("Тендер менеджер");

    private String frontName;

    RoleEnum() {
    }

    RoleEnum(String  frontName) {
        this.frontName = frontName;
    }
    public String getFrontName(){
        return frontName;
    }
}
