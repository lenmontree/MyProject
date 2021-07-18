package com.cmbchina.hello_spirng_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloControler {

    @RequestMapping("/hello")
    public static String hello() {
        return "hello";
    }
}

