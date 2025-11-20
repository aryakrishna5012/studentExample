package com.spring.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.example.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	Users findByUsername(String username);

}
