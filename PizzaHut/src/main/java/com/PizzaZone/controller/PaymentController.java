package com.PizzaZone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PizzaZone.dto.PaymentDto;
import com.PizzaZone.entities.DeliveryStatus;
import com.PizzaZone.entities.Payments;
import com.PizzaZone.services.DeliveryStatusService;
import com.PizzaZone.services.PaymentService;
import com.app.custom_exceptions.ResourceNotFoundException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService payService;
	@Autowired
	private DeliveryStatusService deliveryService;

	
	//add Payment
	@PostMapping("/addPayment")
	public ResponseEntity<?> addPayments(@RequestBody PaymentDto paymentDto)
	{
		try {
			System.out.println(paymentDto);
			Payments newPayment=payService.addPayments(paymentDto);
			System.out.println("Inserted in payments table");
			DeliveryStatus added = deliveryService.addDeliveryStatus(paymentDto,newPayment);
			return Response.success(added);
		}catch(ResourceNotFoundException e) {
			return Response.error(e.getMessage());
		}
		catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
	@GetMapping("/showCurrent/{payId}")
	public ResponseEntity<?> showCurrentPayment(@PathVariable("payId")int payId)
	{
		try {
			Payments curPayment=payService.findPayments(payId);
			System.out.println(curPayment);
			if(curPayment==null)
				return Response.error("No result found");
			return Response.success(curPayment);
		} catch (Exception e) {
			return Response.error(e.getMessage());
		}
	}
	
}
