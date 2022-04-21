package com.springboot.rest.repository;

import com.springboot.rest.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {
    //all CRUD Database Methods
    Users findByEmailId(String emailId);
}
