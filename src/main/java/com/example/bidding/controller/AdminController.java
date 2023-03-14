package com.example.bidding.controller;

import com.example.bidding.enums.RoleEnum;
import com.example.bidding.enums.StatusEnum;
import com.example.bidding.model.client.Client;
import com.example.bidding.model.client.ClientForm;
import com.example.bidding.model.contract.Contract;
import com.example.bidding.model.contract.ContractForm;
import com.example.bidding.model.createForm.CreateFormClient;
import com.example.bidding.model.employee.Employee;
import com.example.bidding.model.employee.EmployeeForm;
import com.example.bidding.service.ClientService;
import com.example.bidding.service.ContractService;
import com.example.bidding.service.EmployeeService;
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
@RequestMapping("/admin")
public class AdminController {

//    @Autowired
//    private ContractService contractService;
    @Autowired
    private EmployeeService employeeService;
//    @Autowired
//    private ClientService clientService;

    private final List<RoleEnum> roleEnumList = Arrays.asList(RoleEnum.ADMIN, RoleEnum.MANAGER, RoleEnum.PRODUCT_MANAGER, RoleEnum.DIRECTOR);
    //Атрибут модели для хранения списка ошибок.
    public static final String FORM_ERROR_ATTR = "errorsList";

    @GetMapping("/")
    public String index(final Model model) {
//        model.addAttribute("contracts", contractService.listAll());
//        model.addAttribute("clients", clientService.findAll());
//        model.addAttribute("employees", employeeService.findAll());
        return "/admin/index";
    }

    @GetMapping("/createEmployee")
    public String createFormEmployee(final Model model) {
        model.addAttribute("roleList", roleEnumList);
        return "/admin/createEmployee";
    }

    //Получаем форму контракта с предварительной валидацией.
    @PostMapping("/createEmployee")
    public String createFormEmployeeProcessing(@ModelAttribute final EmployeeForm form,
                                               final BindingResult bindingResult,
                                               final Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(
                    FORM_ERROR_ATTR,
                    bindingResult.getAllErrors()
            );
            System.out.println(FORM_ERROR_ATTR);
            return createFormEmployee(model);
        }

        Employee employee = employeeService.createEmployee(EmployeeForm.builder()
                        .name(form.getName())
                        .patronymic(form.getPatronymic())
                        .family(form.getFamily())
                        .roleEnum(form.getRoleEnum())
                .build());

        return "redirect:/admin/list-employees";
    }

    @GetMapping("/list-employees")
    public String listClient(final Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "/admin/list-employees";
    }

   }
