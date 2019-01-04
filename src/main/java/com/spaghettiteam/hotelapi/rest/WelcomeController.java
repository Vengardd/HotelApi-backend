package com.spaghettiteam.hotelapi.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class WelcomeController {


    @GetMapping("/api")
    public String welcome() {
        return "Hello world!";
    }


    @GetMapping("/api/logged")
    public String welcomeForLogged() {
        return "Hello world for logged!";
    }
}