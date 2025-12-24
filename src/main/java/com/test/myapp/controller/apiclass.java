package com.test.myapp.controller;

import com.test.myapp.Entity.login;
import com.test.myapp.dto.Registration;
import com.test.myapp.dto.logindto;
import com.test.myapp.service.loginservice;
import com.test.myapp.service.regservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "*")
public class apiclass {

    @Autowired
    loginservice loginService;

    @Autowired
    regservice regservice;

    @GetMapping("/") public String home() { return "index";
    }

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

    @PostMapping("/upload")
    public ResponseEntity<?> getFile(@RequestParam("file")MultipartFile file) throws Exception{

        if(file.isEmpty()){
            return ResponseEntity.badRequest().body("Upload One File");
        }

        String currentDir = System.getProperty("user.dir");
        File uploaddir = new File(currentDir,"/upload");

        if(!uploaddir.exists()){
        uploaddir.mkdir();
        }

        File uploadhere= new File(uploaddir, file.getOriginalFilename());
        System.out.println("uploadhere"+uploadhere);
        file.transferTo(uploadhere);
        return ResponseEntity.ok("File uploaded succesfully " + file.getOriginalFilename());
    }


}
