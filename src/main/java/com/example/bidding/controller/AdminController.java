package com.example.bidding.controller;

import com.example.bidding.enums.ApplicationStatusEnum;
import com.example.bidding.enums.ContractStatusEnum;
import com.example.bidding.enums.RoleEnum;
import com.example.bidding.model.application.Application;
import com.example.bidding.model.client.Customer;
import com.example.bidding.model.contract.ContractNew;
import com.example.bidding.model.createForm.CreateFormApplication;
import com.example.bidding.model.employee.EmployeeForm;
import com.example.bidding.model.product.CreateFormProduct;
import com.example.bidding.model.product.Product;
import com.example.bidding.model.product.Specification;
import com.example.bidding.service.ApplicationService;
import com.example.bidding.service.ContractNewService;
import com.example.bidding.service.CustomerService;
import com.example.bidding.service.EmployeeService;
import com.example.bidding.service.ProductService;
import com.example.bidding.service.SpecifictionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {


    private final ContractNewService contractNewService;

    private final CustomerService customerService;

    private final EmployeeService employeeService;

    private final ApplicationService applicationService;

    private final SpecifictionService specifictionService;

    private final ProductService productService;

    //Атрибут модели для хранения списка ошибок.
    public static final String FORM_ERROR_ATTR = "errorsList";

    public AdminController(ContractNewService contractNewService, CustomerService customerService,
                           EmployeeService employeeService, ApplicationService applicationService,
                           SpecifictionService specifictionService, ProductService productService) {
        this.contractNewService = contractNewService;
        this.customerService = customerService;
        this.employeeService = employeeService;
        this.applicationService = applicationService;
        this.specifictionService = specifictionService;
        this.productService = productService;
    }

    @GetMapping("/")
    public String index() {
        return "/admin/index";
    }

    // Создание и просмотр сотрудников
    @GetMapping("/createEmployee")
    public String createFormEmployee(final Model model) {
        model.addAttribute("roleList", Arrays.asList(RoleEnum.values()));
        return "/admin/createEmployee";
    }


    @PostMapping("/createEmployee")
    public String createFormEmployeeProcessing(@ModelAttribute final EmployeeForm form,
                                               final BindingResult bindingResult,
                                               final Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(
                    FORM_ERROR_ATTR,
                    bindingResult.getAllErrors()
            );
            return createFormEmployee(model);
        }

        employeeService.createEmployee(form);

        return "redirect:/admin/list-employees";
    }

    @GetMapping("/list-employees")
    public String listEmployee(final Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "/admin/list-employees";
    }
// Создание и просмотр заявок

    @GetMapping("/listAplication")
    public String listApplication(final Model model) {
        model.addAttribute("aplications", applicationService.listAll());
        return "/admin/listAplication";
    }

    @GetMapping("/createApplication")
    public String createFormApplication(final Model model) {
        model.addAttribute("applicationStatusList", Arrays.asList(ApplicationStatusEnum.values()));
        model.addAttribute("employees", employeeService.findAll());
        return "/admin/createApplication";
    }

    //Получаем форму  с предварительной валидацией.
    @PostMapping("/createApplication")
    public String createFormApplicationProcessing(
            @ModelAttribute final CreateFormApplication applicationForm,
            final BindingResult bindingResult,
            final Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(
                    FORM_ERROR_ATTR,
                    bindingResult.getAllErrors()
            );
            return createFormApplication(model);
        }

        Specification specification = specifictionService.createSpecification(applicationForm.getApplicationId());
        ContractNew contractNew = contractNewService.createContract(applicationForm);
        Customer customer = customerService.createCustomer(applicationForm);
        applicationService.createApplication(applicationForm, customer, contractNew, specification);
        return "redirect:/admin/listAplication";
    }


//    // Добавление продуктов в специф
//
//    @GetMapping("/aplication/{id}/addProduct")
//    public String addProductFromSpecif(@PathVariable(value = "id") int id,
//                                       final Model model) {
//
//        model.addAttribute("specif", applicationService.findById(id).getSpecif());
//
//        return "/admin/addProduct";
//    }
//
//    @PostMapping("/aplication/{id}/addProduct")
//    public String addProductFromSpecifProcessing(
//            @PathVariable(value = "id") int id,
//            @ModelAttribute final CreateFormProduct createFormProduct,
//            final BindingResult bindingResult,
//            final Model model) {
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute(
//                    FORM_ERROR_ATTR,
//                    bindingResult.getAllErrors()
//            );
//            return "/aplication/{id}/addProduct";
//        }
//
//        Specification specification = specifictionService.findById(applicationService.findById(id).getSpecif().getId());
//
//        Product product = productService.createProduct(createFormProduct);
//        specification.getProducts().add(product);
////        specification.addComment(product);
//
//        return "redirect:/admin/aplication/{id}/specification";
//    }
//
//
//    @GetMapping("/aplication/{id}/specification")
//    public String getSpecification(@PathVariable(value = "id") int id,
////                                   @PathVariable(value = "specifId") int specifId,
//                                       final Model model) {
//
//        Specification specification = applicationService.findById(id).getSpecif();
//        List<Product> productList = specification.getProducts();
//        model.addAttribute("specif",specification);
////        model.addAttribute("specificID", specifId);
//        model.addAttribute("products", productList);
//
//        return "/admin/specification";
//    }
//// 99999999999999999999999999999


    @GetMapping("/aplication/{id}")
    public String viewApplication(@PathVariable int id, final Model model) {

        Application application = applicationService.findById(id);
        if (application.getSpecif().getProducts().isEmpty()) {
            model.addAttribute("product", "productNull");
        } else {
            model.addAttribute("product", application.getSpecif().getProducts());
        }

        model.addAttribute("aplication", application);
        model.addAttribute("customer", application.getCustomer());
        model.addAttribute("contract", application.getContractNew());
        model.addAttribute("employee", application.getEmployee());
        model.addAttribute("contractStatus", application.getContractNew().getContractStatusEnum().name());
        return "/admin/aplication";
    }

    @GetMapping("aplication/{id}/editApplication")
    public String updateApplication(@PathVariable(value = "id") int id, final Model model) {
        model.addAttribute("applicationStatusList", Arrays.asList(ApplicationStatusEnum.values()));
        model.addAttribute("aplication", applicationService.findById(id));

        return "/admin/editApplication";
    }

    @PostMapping("/aplication/{id}/editApplication")
    public String viewOrUpdateApplicationProcessing(
            @PathVariable(value = "id") int id,
            @ModelAttribute final CreateFormApplication applicationForm,
            final BindingResult bindingResult,
            final Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(
                    FORM_ERROR_ATTR,
                    bindingResult.getAllErrors()
            );

            return "/aplication/{id}/editApplication";
        }
        Application application = applicationService.findById(id);

        applicationService.updateApplication(applicationForm, application);

        return "redirect:/admin/aplication/{id}";
    }

    @GetMapping("/listContract")
    public String listContract(final Model model) {

        model.addAttribute("listContract", contractNewService.listAllActiveContract());

        return "admin/listContract";
    }


    @GetMapping("/listContract/{id}")
    public String viewContract(@PathVariable(value = "id") int id, final Model model) {

        model.addAttribute("contract", contractNewService.findById(id));

        return "admin/viewContract";
    }

    @GetMapping("/aplication/{id}/updateContract")
    public String updateContract(@PathVariable(value = "id") int id, final Model model) {

        Application application = applicationService.findById(id);
        model.addAttribute("contract", application.getContractNew());

        model.addAttribute("aplication", application);
        model.addAttribute("contractStatus", Arrays.asList(ContractStatusEnum.values()));
        return "/admin/updateContract";
    }

    @PostMapping("/aplication/{id}/updateContract")
    public String updateContractProcessing(@PathVariable(value = "id") int id,
                                           @ModelAttribute final CreateFormApplication applicationForm,
                                           final BindingResult bindingResult,
                                           final Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute(
                    FORM_ERROR_ATTR,
                    bindingResult.getAllErrors()
            );
            return "/aplication/{id}/updateContract";
        }
        contractNewService.updateContract(applicationForm, applicationService.findById(id).getContractNew());

        return "redirect:/admin/aplication/{id}";
    }


}
