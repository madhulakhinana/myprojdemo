package com.test.myapp.service;

import com.test.myapp.Entity.Registrationentity;
import com.test.myapp.Entity.login;
import com.test.myapp.dto.Registration;
import com.test.myapp.dto.statusdto;
import com.test.myapp.repository.loginrepo;
import com.test.myapp.repository.registrationrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class regservice {
    @Autowired
    registrationrepo registrationrepo;

    @Autowired
    loginrepo loginrepository;

    @Transactional
    public statusdto regb(Registration registration){
        Registrationentity registrationentity = new Registrationentity();
        registrationentity.setFirstname(registration.getFirstname());
        registrationentity.setLastname(registration.getFirstname());
        registrationentity.setEmailid(registration.getEmailid());
        registrationentity.setPassword(registration.getPassword());
        registrationentity.setPhoneno(registration.getPhoneno());
        registrationrepo.save(registrationentity);

        login loginentity = new login();
        loginentity.setLoginId(registration.getEmailid());
        loginentity.setPassword(registration.getPassword());
        loginrepository.save(loginentity);

        statusdto statusDTO =new statusdto();
        statusDTO.setStatus("success");
        return statusDTO;
    }
}
