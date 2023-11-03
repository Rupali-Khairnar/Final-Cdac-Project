package com.PizzaZone.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaZone.dao.ToppingDao;
import com.PizzaZone.entities.Toppings;

@Service
@Transactional
public class ToppingsService {

	@Autowired
	private ToppingDao toppingDao;

	public List<Toppings> findAllToppings() {
		return toppingDao.findAll();
	}

	public List<Toppings> findByToppingId(int toppingId) {
		Toppings toppings = toppingDao.getById(toppingId);
		List<Toppings> toppingList = new ArrayList<Toppings>();
		toppingList.add(toppings);
		return toppingList;
	}

	public Toppings addTopping(Toppings topping) {
		return toppingDao.save(topping);
	}
	
	public void updateTopping(Double price, String toppingName, Integer toppingId) {
		 toppingDao.updateToppingById(price,toppingName,toppingId);
	}
}
