package ru.nnov.nntu.irit.springsecuritydemo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@CrossOrigin("*") // запросы из разных источников
public class AdminController {
    @GetMapping("/")
    public String helloAdminController(){
        return "Уровень доступа администратора";
    }
}
