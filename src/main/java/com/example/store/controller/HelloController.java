package com.example.store.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @RequestMapping(value = "/test/hello")
    @ResponseBody
    public String hello(Model model) {
        return "Hello World!";
    }
}
