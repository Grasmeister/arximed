package com.example.bidding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(value = "/")
    public String hello() {
        System.out.println("Index");
        return "index";
    }
}
