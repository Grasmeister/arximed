package com.example.bidding.service;

import com.example.bidding.enums.ContractStatusEnum;
import com.example.bidding.model.contract.ContractNew;
import com.example.bidding.model.createForm.CreateFormApplication;
import com.example.bidding.repository.ContractNewEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ContractNewService {

    @Autowired
    ContractNewEntityRepository contractNewEntityRepository;

    public List<ContractNew> listAllActiveContract() {
        List<ContractNew> listActiveContract = new ArrayList<>();
        for (ContractNew contractNew : contractNewEntityRepository.findAll()) {
            if (contractNew.getContractStatusEnum().name().equals("CONTRACT_CREATED")) {
                listActiveContract.add(contractNew);
            }
        }
        return listActiveContract;
    }

    public ContractNew findById(int id) {
        return contractNewEntityRepository.findById(id).orElse(new ContractNew());
    }

    public ContractNew createContract(CreateFormApplication formApplication) {
        ContractNew contract = new ContractNew();

        if (formApplication.getContractStatusEnum() == null) {
            contract.setContractStatusEnum(ContractStatusEnum.THERE_IS_NO_CONTRACT);
            contract.setNumberOfSignedContract("Отсутствует");
            return contractNewEntityRepository.save(contract);
        }
        contract.setContractStatusEnum(Arrays.asList(ContractStatusEnum.values())
                .get(formApplication.getContractStatusEnum().ordinal()));

        if (formApplication.getNumberOfSignedContract() != null) {
            contract.setNumberOfSignedContract(formApplication.getNumberOfSignedContract());
        }
        if (formApplication.getDateOfContractSigning() != null) {
            contract.setDateOfContractSigning(formApplication
                    .getTime(formApplication.getDateOfContractSigning()));
        }
        contract.setContractPrice(formApplication.getContractPrice());

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

    public void updateContract(CreateFormApplication formApplication, ContractNew contract) {

        if (formApplication.getNumberOfSignedContract() != null) {
            contract.setNumberOfSignedContract(formApplication.getNumberOfSignedContract());
        }
        if (formApplication.getDateOfContractSigning() != null) {
            contract.setDateOfContractSigning(formApplication
                    .getTime(formApplication.getDateOfContractSigning()));
        }
        contract.setContractPrice(formApplication.getContractPrice());

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

        contract.setAmountOfContractEnsuring(formApplication.getAmountOfContractEnsuring());
        contract.setAmountOfContractEnsuringListedToCustomer(formApplication.getAmountOfContractEnsuringListedToCustomer());

        contract.setContractStatusEnum(Arrays.asList(ContractStatusEnum.values()).get(formApplication.getContractStatusEnum().ordinal()));

        contract.setTermsOfDelivery(formApplication.getTermsOfDelivery());
        contract.setShelfLifeOfProductAtTimeOfDelivery(formApplication.getShelfLifeOfProductAtTimeOfDelivery());

        contractNewEntityRepository.save(contract);
    }

}
