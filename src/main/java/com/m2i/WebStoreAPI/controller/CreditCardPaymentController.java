package com.m2i.WebStoreAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.WebStoreAPI.entity.CreditCardPayment;
import com.m2i.WebStoreAPI.service.CreditCardPaymentService;

@RestController
@RequestMapping("/creditcardpayment")
public class CreditCardPaymentController {
	
	@Autowired
	CreditCardPaymentService cService;
	
	@GetMapping("/{id}")
	public CreditCardPayment getCreditCardPaymentById(@PathVariable("id") int id) {
		return cService.getById(id);
	}
	
	@GetMapping
	public List<CreditCardPayment> getAllCreditCardPayment(){
		return cService.getAll();
	}
	
	@PostMapping
	public void postPayment(@RequestBody CreditCardPayment c) {
		cService.create(c);
	}
	
	@PutMapping("/{id}")
	public void putCreditCardPayment(@PathVariable("id") int id,@RequestBody CreditCardPayment c) {
		cService.update(id, c);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCreditCardPayment(@PathVariable("id") int id) {
		cService.delete(id);
	}

}
