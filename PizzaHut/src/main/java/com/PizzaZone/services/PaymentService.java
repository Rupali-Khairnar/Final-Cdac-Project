package com.PizzaZone.services;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.PizzaZone.dao.AddressDao;
import com.PizzaZone.dao.CartDao;
import com.PizzaZone.dao.PaymentDao;
import com.PizzaZone.dao.UserDao;
import com.PizzaZone.dto.DtoEntityConvertor;
import com.PizzaZone.dto.PaymentDto;
import com.PizzaZone.entities.Payments;
import com.PizzaZone.entities.Users;
import com.app.custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class PaymentService {
	@Autowired
	private DtoEntityConvertor convertor;
	@Autowired
	private PaymentDao paymentDao;	
	@Autowired
	private CartDao cartDao;
	@Autowired UserDao userDao;
	
	public Payments addPayments(PaymentDto paymentDto)
	{
		Double totalAmount = cartDao.findTotalAmount(paymentDto.getUserId());
		
//		paymentDto.setMode("Card Payment");
//		paymentDto.setPayStatus("success");
		System.out.println(totalAmount);
		if(totalAmount != 0) {
			Payments add= new Payments();
			Users user= userDao.findById(paymentDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("invalid user id"));
			add.setUsers(user);
			add.setMode("Card Payment");
			add.setPayStatus("success");
			add.setTotalAmount(totalAmount);
//			Payments add=convertor.toPaymentEntity(paymentDto,totalAmount);
			System.out.println(add);
			paymentDao.save(add);
			return add;
		}
		throw new ResourceNotFoundException("total amount is zero");
	}
	
	public Payments findPayments(int payId)
	{
		Payments togetPayments=paymentDao.getById(payId);
		return togetPayments;
		
	}
}
