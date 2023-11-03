package com.PizzaZone.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaZone.entities.Users;

public interface UserDao extends JpaRepository<Users, Integer> {
	Users findByEmail(String email);
	Users findByPhoneNo(String phoneNo);
}
