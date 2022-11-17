package com.project.repository;

import com.project.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<User, Long> {
    User findUserByEmail(String email);
}
