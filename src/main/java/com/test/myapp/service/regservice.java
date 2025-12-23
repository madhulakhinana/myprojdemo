package com.test.myapp.service;

import com.test.myapp.Entity.Registrationentity;
import com.test.myapp.dto.Registration;
import com.test.myapp.repository.registrationrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class regservice {
    @Autowired
    registrationrepo registrationrepo;

    Registrationentity registrationentity = new Registrationentity();

    Registration Registration = new Registration();

    public String regb(){
        registrationentity.setFirstname(Registration.getFirstname());
        registrationrepo.save(registrationentity);
        return "s";
    }
}
