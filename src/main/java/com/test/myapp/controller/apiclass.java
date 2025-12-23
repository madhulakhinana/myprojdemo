package com.test.myapp.controller;

import com.test.myapp.Entity.login;
import com.test.myapp.dto.Registration;
import com.test.myapp.dto.logindto;
import com.test.myapp.service.loginservice;
import com.test.myapp.service.regservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class apiclass {

    @Autowired
    loginservice loginService;

    @Autowired
    regservice regservice;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody logindto logindto){
        String loginresp= loginService.login(logindto);
       return ResponseEntity.ok(loginresp);
    }

    @PostMapping("/register")
    public String registration(@RequestBody Registration registration){
        String regresp= regservice.regb();
        return regresp;
    }


}
