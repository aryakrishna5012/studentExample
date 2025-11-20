package com.spring.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.example.entity.Users;

public interface UserRepository extends JpaRepository<Users, String>{

	Users findByUsername(String username);

}
