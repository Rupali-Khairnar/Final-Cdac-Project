package com.PizzaZone.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaZone.entities.Address;
import com.PizzaZone.entities.Users;

public interface AddressDao extends JpaRepository<Address, Integer> {
	List<Address> findByUser(Users user);
}