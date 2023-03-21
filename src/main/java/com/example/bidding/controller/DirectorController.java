package com.example.bidding.controller;

//@Controller
//@RequestMapping("/director")
public class DirectorController {

//
//    @Autowired
//    private ContractService contractService;
//    @Autowired
//    private EmployeeService employeeService;
//    @Autowired
//    private ClientService clientService;
//
//    private final List<RoleEnum> roleEnumList = Arrays.asList(RoleEnum.values());
//    //Атрибут модели для хранения списка ошибок.
//    public static final String FORM_ERROR_ATTR = "errorsList";
//
//    @GetMapping("/")
//    public String index(final Model model) {
////        model.addAttribute("contracts", contractService.listAll());
////        model.addAttribute("clients", clientService.findAll());
////        model.addAttribute("employees", employeeService.findAll());
//        return "/admin/index";
//    }
//
//    @GetMapping("/listContract")
//    public String listContract(final Model model) {
//        model.addAttribute("contracts", contractService.listAll());
//
//
//        return "/admin/listContract";
//    }
//
//    @GetMapping("/createEmployee")
//    public String createFormEmployee(final Model model) {
//        model.addAttribute("roleList", roleEnumList);
//        return "/admin/createEmployee";
//    }
//
//    //Получаем форму контракта с предварительной валидацией.
//    @PostMapping("/createEmployee")
//    public String createFormEmployeeProcessing(@ModelAttribute final EmployeeForm form,
//                                               final BindingResult bindingResult,
//                                               final Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute(
//                    FORM_ERROR_ATTR,
//                    bindingResult.getAllErrors()
//            );
//            System.out.println(FORM_ERROR_ATTR);
//            return createFormEmployee(model);
//        }
//
//        Employee employee = employeeService.createEmployee(EmployeeForm.builder()
//                .name(form.getName())
//                .patronymic(form.getPatronymic())
//                .family(form.getFamily())
//                .roleEnum(roleEnumList.get(form.getRoleEnum().ordinal()))
//                .build());
//
//        return "redirect:/admin/list-employees";
//    }
//
//    @GetMapping("/list-employees")
//    public String listEmployee(final Model model) {
//        model.addAttribute("employees", employeeService.findAll());
//        return "/admin/list-employees";
//    }
//
//    @GetMapping("/createClient")
//    public String createFormClient(final Model model) {
//        return "/manager/createClient";
//    }
//
//    //Получаем форму  с предварительной валидацией.
//    @PostMapping("/createClient")
//    public String createFormClientProcessing(@ModelAttribute final CreateFormClient form,
//                                             final BindingResult bindingResult,
//                                             final Model model) {
//        if (bindingResult.hasErrors()) {
//
//            model.addAttribute(
//                    FORM_ERROR_ATTR,
//                    bindingResult.getAllErrors()
//            );
//
//            return createFormClient(model);
//        }
//
//        Client client = clientService.createClient(ClientForm.builder()
//                .name(form.getName())
//                .affiliation(form.getAffiliation())
//                .inn(form.getInn())
//                .kpp(form.getKpp())
//                .phone(form.getPhone())
//                .addressCountry(form.getAddressCountry())
//                .addressCity(form.getAddressCity())
//                .addressStreet(form.getAddressStreet())
//                .addressHouseNumber(form.getAddressHouseNumber())
//                .addressOfficeNumber(form.getAddressOfficeNumber())
//                .bankName(form.getBankName())
//                .bankBik(form.getBankBik())
//                .bankCorAccount(form.getBankCorAccount())
//                .bankAccount(form.getBankAccount())
//                .build());
//
//        return "redirect:/manager/listClient";
//    }
//
//    @GetMapping("/listClient")
//    public String listClient(final Model model) {
//        model.addAttribute("clients", clientService.findAll());
//        return "/admin/listClient";
//    }

}
