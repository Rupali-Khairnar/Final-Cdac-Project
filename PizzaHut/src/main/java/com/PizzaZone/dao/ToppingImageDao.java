package com.PizzaZone.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PizzaZone.entities.ToppingImages;

public interface ToppingImageDao extends JpaRepository<ToppingImages,Integer>{

	ToppingImages findByToppingImgId(int toppingImgId);
}
