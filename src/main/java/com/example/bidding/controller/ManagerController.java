package com.example.bidding.controller;

import com.example.bidding.enums.StatusEnum;
import com.example.bidding.model.client.Client;
import com.example.bidding.model.client.ClientForm;
import com.example.bidding.model.contract.Contract;
import com.example.bidding.model.contract.ContractForm;
import com.example.bidding.model.createForm.CreateFormClient;
import com.example.bidding.service.ClientService;
import com.example.bidding.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ContractService contractService;

    @Autowired
    private ClientService clientService;

    private final List<StatusEnum> statusEnumList = Arrays.asList(StatusEnum.ZAPOLNENIE, StatusEnum.PODACHA, StatusEnum.ISPOLNENIE, StatusEnum.CLOSE, StatusEnum.OTKAZ);
    //Атрибут модели для хранения списка ошибок.
    public static final String FORM_ERROR_ATTR = "errorsList";

    @GetMapping("/")
    public String index(final Model model) {
        model.addAttribute("contracts", contractService.listAll());


        return "/manager/index";
    }

    @GetMapping("/createContract")
    public String createFormContract(final Model model) {
        model.addAttribute("clients", clientService.findAll());

        model.addAttribute("statusList", StatusEnum.values());
        return "/manager/createContract";
    }

    //Получаем форму контракта с предварительной валидацией.
    @PostMapping("/createContract")
    public String createFormContractProcessing(@ModelAttribute final ContractForm form,
                                               final BindingResult bindingResult,
                                               final Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(
                    FORM_ERROR_ATTR,
                    bindingResult.getAllErrors()
            );
            System.out.println(FORM_ERROR_ATTR);
            return createFormContract(model);
        }

        Contract contract = contractService.createContract(ContractForm.builder()
                .contractId(form.getContractId())
                .contractAmount(form.getContractAmount())
                .dateAuction(form.getDateAuction())
                .contractEndDate(form.getContractEndDate())
                .purchaseAmount(form.getPurchaseAmount())
                .client(form.getClient())
                .statusEnum(statusEnumList.get(form.getStatusEnum().ordinal()))
//                .employee(form.employee)
                .build());

        return "redirect:/manager/";
    }

    @GetMapping("/listClient")
    public String listClient(final Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "/manager/listClient";
    }

    @GetMapping("/createClient")
    public String createFormClient(final Model model) {
//        model.addAttribute("clients", clientService.findAll());
        return "/manager/createClient";
    }

    //Получаем форму контракта с предварительной валидацией.
    @PostMapping("/createClient")
    public String createFormClientProcessing(@ModelAttribute final CreateFormClient form,
                                             final BindingResult bindingResult,
                                             final Model model) {
        if (bindingResult.hasErrors()) {

            model.addAttribute(
                    FORM_ERROR_ATTR,
                    bindingResult.getAllErrors()
            );

            return createFormClient(model);
        }


        Client client = clientService.createClient(ClientForm.builder()
                .name(form.getName())
                .affiliation(form.getAffiliation())
                .inn(form.getInn())
                .kpp(form.getKpp())
                .phone(form.getPhone())
                .addressCountry(form.getAddressCountry())
                .addressCity(form.getAddressCity())
                .addressStreet(form.getAddressStreet())
                .addressHouseNumber(form.getAddressHouseNumber())
                .addressOfficeNumber(form.getAddressOfficeNumber())
                .bankName(form.getBankName())
                .bankBik(form.getBankBik())
                .bankCorAccount(form.getBankCorAccount())
                .bankAccount(form.getBankAccount())
                .build());

        return "redirect:/manager/listClient";
    }
}
