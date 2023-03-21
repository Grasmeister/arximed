package com.example.bidding.service;

import com.example.bidding.enums.ApplicationStatusEnum;
import com.example.bidding.model.application.Application;
import com.example.bidding.model.client.Customer;
import com.example.bidding.model.contract.ContractNew;
import com.example.bidding.model.createForm.CreateFormApplication;
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

    public Application findByApplicationId(long id) {
        return applicationEntityRepository.findByApplicationId(id);
    }

    public Application findById(int id) {
        return applicationEntityRepository.findById(id).orElse(new Application());
    }

    public void createApplication(CreateFormApplication formApplication, Customer customer, ContractNew contractNew) {
        Application application = new Application();

        application.setApplicationId(formApplication.getApplicationId());
        application.setInitialMaximumPrice(formApplication.getInitialMaximumPrice());
        application.setProductPurchase(formApplication.getProductPurchase());
        application.setApplicationDeadlineDate(formApplication
                .getTime(formApplication.getApplicationDeadlineDate()));
        application.setEndDateOfApplicationConsideration(formApplication
                .getTime(formApplication.getEndDateOfApplicationConsideration()));
        application.setAuctionDate(formApplication.getTime(formApplication.getAuctionDate()));
        application.setElectronicPlatform(formApplication.getElectronicPlatform());
        application.setApplicationStatusEnum(Arrays.asList(ApplicationStatusEnum.values())
                .get(formApplication.getApplicationStatusEnum().ordinal()));
        application.setReasonForRejectionOfApplication(formApplication.getReasonForRejectionOfApplication());
        application.setAmountOfApplicationEnsuring(formApplication.getAmountOfApplicationEnsuring());
        application.setAmountOfContractEnsuring(formApplication.getAmountOfContractEnsuring());
        application.setAmountOfContractEnsuringListedToCustomer(formApplication
                .getAmountOfContractEnsuringListedToCustomer());
        application.setAuctionWinner(formApplication.getAuctionWinner());
        application.setFolderOnDisk(formApplication.getFolderOnDisk());
        application.setComments(formApplication.getComments());
        application.setEmployee(formApplication.getEmployee());
        application.setCustomer(customer);
        application.setContractNew(contractNew);


        applicationEntityRepository.save(application);
    }

    public void updateApplication(CreateFormApplication formApplication, ContractNew contractNew, Application application) {

        //        applicationUpdate.setAuctionDate(formApplication.getTime(formApplication.getAuctionDate()));
        application.setApplicationStatusEnum(formApplication.getApplicationStatusEnum());
        application.setReasonForRejectionOfApplication(formApplication.getReasonForRejectionOfApplication());
        application.setAmountOfContractEnsuringListedToCustomer(formApplication
                .getAmountOfContractEnsuringListedToCustomer());
        application.setAuctionWinner(formApplication.getAuctionWinner());
        application.setComments(formApplication.getComments());
        application.setContractNew(contractNew);

        applicationEntityRepository.save(application);
    }
    //Начальная максимальная цена    private double initialMaximumPrice; не нужно
    //Предмет закупки    private String productPurchase;не нужно
    //Дата окончания подачи заявки    private Timestamp applicationDeadlineDate; не нужно
    //Дата окончание рассмотрения заявки    private Timestamp endDateOfApplicationConsideration; не нужно
    //Дата аукциона   private Timestamp auctionDate;не нужно
    //Элетронная площадка    private String electronicPlatform; не нужно
    //Статус заявки    private ApplicationStatusEnum applicationStatusEnum; изменится
    //Причина отклонения заявки    private String reasonForRejectionOfApplication; не нужнно
    //Размер обеспечения заявки    private double amountOfApplicationEnsuring; не нужно
    //Размер обеспечения контракта    private double amountOfContractEnsuring;не нужно
    //Размер обеспечение контракта перечисленные заказчику    private double amountOfContractEnsuringListedToCustomer;
    // Победитель аукциона    private String auctionWinner;
    //Ссылка на общем диске    private String folderOnDisk; не нужно
    //Комментарии    private String comments;
//    private Employee employee;не нужно
//    private Customer customer; не нкжно
//    private ContractNew contractNew; изменится
}
