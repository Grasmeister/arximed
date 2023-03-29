package com.example.bidding.service;

import com.example.bidding.enums.ApplicationStatusEnum;
import com.example.bidding.model.application.Application;
import com.example.bidding.model.client.Customer;
import com.example.bidding.model.contract.ContractNew;
import com.example.bidding.model.createForm.CreateFormApplication;
import com.example.bidding.model.product.Specification;
import com.example.bidding.repository.ApplicationEntityRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ApplicationService {

    private final ApplicationEntityRepository applicationEntityRepository;

    public ApplicationService(ApplicationEntityRepository applicationEntityRepository) {
        this.applicationEntityRepository = applicationEntityRepository;
    }

    public List<Application> listAll() {
        return applicationEntityRepository.findAll();
    }



    public Application findById(int id) {
        return applicationEntityRepository.findById(id).orElse(new Application());
    }

    public void createApplication(CreateFormApplication formApplication, Customer customer, ContractNew contractNew,
                                  Specification specification) {
        Application application = new Application();


        application.setApplicationId(formApplication.getApplicationId());
        application.setInitialMaximumPrice(formApplication.getInitialMaximumPrice());
        application.setPurchasePrice(formApplication.getPurchasePrice());
        application.setProductPurchase(formApplication.getProductPurchase());

        application.setCustomer(customer);
        application.setSpecif(specification);

        application.setApplicationDeadlineDate(formApplication
                .getTime(formApplication.getApplicationDeadlineDate()));
        application.setAuctionDate(formApplication.getTime(formApplication.getAuctionDate()));

        application.setAmountOfApplicationEnsuring(formApplication.getAmountOfApplicationEnsuring());
        application.setElectronicPlatform(formApplication.getElectronicPlatform());

        application.setFolderOnDisk(formApplication.getFolderOnDisk());
        application.setEmployee(formApplication.getEmployee());
        application.setComments(formApplication.getComments());
        application.setApplicationStatusEnum(ApplicationStatusEnum.NEW);

        application.setContractNew(contractNew);

        applicationEntityRepository.save(application);
    }

    public void updateApplication(CreateFormApplication formApplication, Application application) {

        application.setApplicationStatusEnum(Arrays.asList(ApplicationStatusEnum.values())
                .get(formApplication.getApplicationStatusEnum().ordinal()));
        application.setReasonForRejectionOfApplication(formApplication.getReasonForRejectionOfApplication());
        application.setAuctionWinner(formApplication.getAuctionWinner());
        application.setComments(formApplication.getComments());

        applicationEntityRepository.save(application);
    }
}
