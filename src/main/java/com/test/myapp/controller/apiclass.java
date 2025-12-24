package com.test.myapp.controller;

import com.test.myapp.Entity.login;
import com.test.myapp.dto.Registration;
import com.test.myapp.dto.logindto;
import com.test.myapp.dto.statusdto;
import com.test.myapp.service.fileservice;
import com.test.myapp.service.loginservice;
import com.test.myapp.service.regservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "*")
public class apiclass {

    @Autowired
    loginservice loginService;

    @Autowired
    regservice regservice;

    @Autowired
    fileservice fs;

    @GetMapping("/")
    public String home() { return "index";
    }

    @PostMapping("/login")
    public ResponseEntity<statusdto> login(@RequestBody logindto logindto){
        statusdto loginresp= loginService.login(logindto);
       return ResponseEntity.ok(loginresp);
    }

    @PostMapping("/register")
    public statusdto registrations(@RequestBody Registration registration){
        statusdto regresp= regservice.regb(registration);
        return regresp;
    }

    @PostMapping("/upload")
    public ResponseEntity<?> getFile(@RequestParam("file")MultipartFile file) throws Exception{

        if(file.isEmpty()){
            return ResponseEntity.badRequest().body("Upload One File");
        }
            fs.readfile(file);

        return null;
    }


}
