package com.test.myapp.service;

import com.test.myapp.dto.logindto;
import org.springframework.stereotype.Service;

@Service
public class loginservice {

    public String login(logindto logindto) {
        String response = null;
        if (logindto.getLoginId().equalsIgnoreCase("madhu")) {
            response = "ok";
        }
        return response;
    }
}