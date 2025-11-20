package com.spring.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.example.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByUsername(String username);

}
