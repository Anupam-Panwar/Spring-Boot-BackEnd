package com.springboot.rest.repository;

import com.springboot.rest.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
    //all CRUD Database Methods
    User findByEmailId(String emailId);
}
