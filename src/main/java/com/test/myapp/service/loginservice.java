package com.test.myapp.service;

import com.test.myapp.Entity.login;
import com.test.myapp.dto.logindto;
import com.test.myapp.repository.loginrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class loginservice {

    @Autowired
    loginrepo loginrepo;

    public String login(logindto logindto) {

        String resp;
        if(loginrepo.findById(logindto.getLoginId()).isPresent()){
            resp =loginrepo.findById(logindto.getLoginId()).get().getPassword();
        }else{
            resp = "not present";
        }
        return resp;

    }
}