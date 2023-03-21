package com.example.bidding.service;

import com.example.bidding.model.contract.ContractNew;
import com.example.bidding.model.createForm.CreateFormApplication;
import com.example.bidding.repository.ContractNewEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractNewService {

    @Autowired
    ContractNewEntityRepository contractNewEntityRepository;

    public List<ContractNew> listAll() {
        return contractNewEntityRepository.findAll();
    }

    public ContractNew createContract(CreateFormApplication formApplication) {
        ContractNew contract = new ContractNew();
        if (formApplication.getNumberOfSignedContract()!=null) {
            contract.setNumberOfSignedContract(formApplication.getNumberOfSignedContract());
        }
        if (formApplication.getDateOfContractSigning()!=null) {
            contract.setDateOfContractSigning(formApplication
                    .getTime(formApplication.getDateOfContractSigning()));
        }
        contract.setContractPrice(formApplication.getContractPrice());

        if (formApplication.getDateOfContractSigning()!=null) {
            contract.setEnsuringRefund(formApplication.getEnsuringRefund());
        }

        contract.setDeliveryTimeOfProduct(formApplication.getDeliveryTimeOfProduct());
        if (formApplication.getContractExecutionPeriod() != null) {
            contract.setContractExecutionPeriod(formApplication
                    .getTime(formApplication.getContractExecutionPeriod()));
        }
        if (formApplication.getPlaceOfDeliveryOfProduct() != null) {
            contract.setPlaceOfDeliveryOfProduct(formApplication.getPlaceOfDeliveryOfProduct());
        }
        if (formApplication.getContactPerson() != null) {
            contract.setContactPerson(formApplication.getContactPerson());
        }
        if (formApplication.getContactPhone() != 0) {
            contract.setContactPhone(formApplication.getContactPhone());
        }
        if (formApplication.getContactEmail() != null) {
            contract.setContactEmail(formApplication.getContactEmail());
        }

        return contractNewEntityRepository.save(contract);
    }
    public ContractNew updateContract(CreateFormApplication formApplication, ContractNew contract) {
        if (formApplication.getNumberOfSignedContract()!=null) {
            contract.setNumberOfSignedContract(formApplication.getNumberOfSignedContract());
        }
        if (formApplication.getDateOfContractSigning()!=null) {
            contract.setDateOfContractSigning(formApplication
                    .getTime(formApplication.getDateOfContractSigning()));
        }
        contract.setContractPrice(formApplication.getContractPrice());

        if (formApplication.getDateOfContractSigning()!=null) {
            contract.setEnsuringRefund(formApplication.getEnsuringRefund());
        }

        contract.setDeliveryTimeOfProduct(formApplication.getDeliveryTimeOfProduct());
        if (formApplication.getContractExecutionPeriod() != null) {
            contract.setContractExecutionPeriod(formApplication
                    .getTime(formApplication.getContractExecutionPeriod()));
        }
        if (formApplication.getPlaceOfDeliveryOfProduct() != null) {
            contract.setPlaceOfDeliveryOfProduct(formApplication.getPlaceOfDeliveryOfProduct());
        }
        if (formApplication.getContactPerson() != null) {
            contract.setContactPerson(formApplication.getContactPerson());
        }
        if (formApplication.getContactPhone() != 0) {
            contract.setContactPhone(formApplication.getContactPhone());
        }
        if (formApplication.getContactEmail() != null) {
            contract.setContactEmail(formApplication.getContactEmail());
        }

        return contractNewEntityRepository.save(contract);
    }



    //Номер подписаного контракта    private String numberOfSignedContract;
    //Дата подписания контракта    private Timestamp dateOfContractSigning;
    //Цена контракта    private double contractPrice;
    //Возврат обеспечения    private String ensuringRefund;
    // Срок поставки товара    private int deliveryTimeOfProduct;
    //Срок исполнения контракта    private Timestamp contractExecutionPeriod;
    //Место поставки товара    private String placeOfDeliveryOfProduct;
    //Контактное лицо ФИО    private String contactPerson;
    //Контактный телефон по контракту    private long contactPhone;
    //Контактный Email по контракту    private String contactEmail;
}
