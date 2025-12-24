package com.test.myapp.service;

import com.test.myapp.controller.apiclass;
import com.test.myapp.dto.Registration;
import com.test.myapp.dto.statusdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class fileservice {

    statusdto statusDTO =new statusdto();

    @Autowired
    regservice regservice;

    ObjectMapper objectMapper = new ObjectMapper();



    public fileservice(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public statusdto readfile(MultipartFile file) throws IOException {

        statusDTO.setStatus("Failure");
        InputStreamReader reader =new InputStreamReader(file.getInputStream());
        try (BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                Registration registration= objectMapper.readValue(line,Registration.class);
                regservice.regb(registration);
            }

        }

        catch (IOException e) {
            e.printStackTrace();
        }
       return statusDTO;

    }
}
