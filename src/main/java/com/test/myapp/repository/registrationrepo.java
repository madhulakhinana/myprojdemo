package com.test.myapp.repository;

import com.test.myapp.Entity.Registrationentity;
import org.springframework.data.repository.CrudRepository;

public interface registrationrepo extends CrudRepository<Registrationentity, String> {
}
