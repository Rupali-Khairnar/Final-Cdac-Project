package com.PizzaZone.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaZone.entities.Payments;

public interface PaymentDao extends JpaRepository<Payments, Integer>{

}
