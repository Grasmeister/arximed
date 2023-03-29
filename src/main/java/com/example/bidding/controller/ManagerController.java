package com.example.bidding.controller;

import com.example.bidding.enums.ApplicationStatusEnum;
import com.example.bidding.model.application.Application;
import com.example.bidding.model.client.Customer;
import com.example.bidding.model.contract.ContractNew;
import com.example.bidding.model.createForm.CreateFormApplication;
import com.example.bidding.service.ApplicationService;
import com.example.bidding.service.ContractNewService;
import com.example.bidding.service.CustomerService;
import com.example.bidding.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequestMapping("/manager")
public class ManagerController {


    private final ContractNewService contractNewService;

    private final CustomerService customerService;

    private final EmployeeService employeeService;

    private final ApplicationService applicationService;

    //Атрибут модели для хранения списка ошибок.
    public static final String FORM_ERROR_ATTR = "errorsList";

    public ManagerController(ContractNewService contractNewService, CustomerService customerService,
                             EmployeeService employeeService, ApplicationService applicationService) {
        this.contractNewService = contractNewService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.applicationService = applicationService;
    }

    @GetMapping("/")
    public String index() {
        return "/manager/index";
    }

//    // Создание и просмотр сотрудников
//    @GetMapping("/createEmployee")
//    public String createFormEmployee(final Model model) {
//        model.addAttribute("roleList", Arrays.asList(RoleEnum.values()));
//        return "/manager/createEmployee";
//    }
//
//
//    @PostMapping("/createEmployee")
//    public String createFormEmployeeProcessing(@ModelAttribute final EmployeeForm form,
//                                               final BindingResult bindingResult,
//                                               final Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute(
//                    FORM_ERROR_ATTR,
//                    bindingResult.getAllErrors()
//            );
//            return createFormEmployee(model);
//        }
//
//        employeeService.createEmployee(form);
//
//        return "redirect:/manager/list-employees";
//    }
//
//    @GetMapping("/list-employees")
//    public String listEmployee(final Model model) {
//        model.addAttribute("employees", employeeService.findAll());
//        return "/manager/list-employees";
//    }
// Создание и просмотр заявок

    @GetMapping("/listAplication")
    public String listApplication(final Model model) {
        model.addAttribute("aplications", applicationService.listAll());
        return "/manager/listAplication";
    }

    @GetMapping("/createApplication")
    public String createFormApplication(final Model model) {
        model.addAttribute("applicationStatusList", Arrays.asList(ApplicationStatusEnum.values()));
        model.addAttribute("employees", employeeService.findAll());
        return "/manager/createApplication";
    }

//    //Получаем форму  с предварительной валидацией.
//    @PostMapping("/createApplication")
//    public String createFormApplicationProcessing(
//            @ModelAttribute final CreateFormApplication applicationForm,
//            final BindingResult bindingResult,
//            final Model model) {
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute(
//                    FORM_ERROR_ATTR,
//                    bindingResult.getAllErrors()
//            );
//            return createFormApplication(model);
//        }
//        ContractNew contractNew = contractNewService.createContract(applicationForm);
//        Customer customer = customerService.createCustomer(applicationForm);
//        applicationService.createApplication(applicationForm, customer, contractNew);
//        return "redirect:/manager/listAplication";
//    }


    @GetMapping("/aplication/{id}")
    public String viewApplication(@PathVariable int id, final Model model) {

        Application application = applicationService.findById(id);
        ContractNew contractNew = application.getContractNew();
        Customer customer = application.getCustomer();
        model.addAttribute("aplication", application);
        model.addAttribute("customer", application.getCustomer());
        model.addAttribute("contract", application.getContractNew());
        model.addAttribute("employee", application.getEmployee());
        model.addAttribute("contractStatus", application.getContractNew().getContractStatusEnum().name());
        return "/manager/aplication";
    }

//    @GetMapping("aplication/{id}/editApplication")
//    public String updateApplication(@PathVariable(value = "id") int id, final Model model) {
//        model.addAttribute("applicationStatusList", Arrays.asList(ApplicationStatusEnum.values()));
//        model.addAttribute("aplication", applicationService.findById(id));
//
//        return "/manager/editApplication";
//    }

//    @PostMapping("/aplication/{id}/editApplication")
//    public String viewOrUpdateApplicationProcessing(
//            @PathVariable(value = "id") int id,
//            @ModelAttribute final CreateFormApplication applicationForm,
//            final BindingResult bindingResult,
//            final Model model) {
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute(
//                    FORM_ERROR_ATTR,
//                    bindingResult.getAllErrors()
//            );
//
//            return "/aplication/{id}/editApplication";
//        }
//        Application application = applicationService.findById(id);
//
//        applicationService.updateApplication(applicationForm, application);
//
//        return "redirect:/manager/aplication/{id}";
//    }

    @GetMapping("/listContract")
    public String listContract(final Model model) {

        model.addAttribute("listContract", contractNewService.listAllActiveContract());

        return "manager/listContract";
    }


    @GetMapping("/listContract/{id}")
    public String viewContract(@PathVariable(value = "id") int id, final Model model) {

        model.addAttribute("contract", contractNewService.findById(id));

        return "manager/viewContract";
    }

//    @GetMapping("/aplication/{id}/updateContract")
//    public String updateContract(@PathVariable(value = "id") int id, final Model model) {
//
//        Application application = applicationService.findById(id);
//        model.addAttribute("contract", application.getContractNew());
//
//        model.addAttribute("aplication", application);
//        model.addAttribute("contractStatus", Arrays.asList(ContractStatusEnum.values()));
//        return "/manager/updateContract";
//    }
//
//    @PostMapping("/aplication/{id}/updateContract")
//    public String updateContractProcessing(@PathVariable(value = "id") int id,
//                                           @ModelAttribute final CreateFormApplication applicationForm,
//                                           final BindingResult bindingResult,
//                                           final Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute(
//                    FORM_ERROR_ATTR,
//                    bindingResult.getAllErrors()
//            );
//            return "/aplication/{id}/updateContract";
//        }
//        contractNewService.updateContract(applicationForm, applicationService.findById(id).getContractNew());
//
//        return "redirect:/manager/aplication/{id}";
//    }

}
