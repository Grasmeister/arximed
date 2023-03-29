package com.example.bidding.service;

import com.example.bidding.model.client.Customer;
import com.example.bidding.model.createForm.CreateFormApplication;
import com.example.bidding.repository.CustomerEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerEntityRepository customerEntityRepository;

    public Customer createCustomer(CreateFormApplication formApplication) {
        Customer customer = new Customer();

        customer.setNameCustomer(formApplication.getNameCustomer());
        customer.setInnCustomer(formApplication.getInnCustomer());
        customer.setCityCustomer(formApplication.getCityCustomer());

        return customerEntityRepository.save(customer);
    }
}
