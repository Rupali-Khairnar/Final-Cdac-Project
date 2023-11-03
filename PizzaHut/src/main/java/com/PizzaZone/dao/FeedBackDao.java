package com.PizzaZone.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaZone.entities.Feedback;

public interface FeedBackDao extends JpaRepository<Feedback, Integer>{

   
}