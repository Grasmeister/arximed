package com.example.bidding.model.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Specification {

    @Id
    @GeneratedValue
    private int id;

    //Номер заявки
    @Column(name = "application_number")
    private long applicationNumber;

    //Продукт(товар)
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();


//    public void addComment(Product product) {
//        this.products.add(product);
//        product.setSpecif(this);
//    }
//
//    public void removeComment(Product product) {
//        this.products.remove(product);
//        product.setSpecif(null);
//    }


}
