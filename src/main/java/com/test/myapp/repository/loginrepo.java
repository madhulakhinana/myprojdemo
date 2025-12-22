package com.test.myapp.repository;

import com.test.myapp.Entity.login;
import org.springframework.data.repository.CrudRepository;

public interface loginrepo extends CrudRepository<login, String> {
}
