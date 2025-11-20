package com.spring.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table
public class Users {
	
	private long id;
	private String username;
	private String password;
	private String role;

}
