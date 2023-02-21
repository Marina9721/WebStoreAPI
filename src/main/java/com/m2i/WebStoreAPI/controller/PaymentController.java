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

import com.m2i.WebStoreAPI.entity.Payment;
import com.m2i.WebStoreAPI.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService vService;
	
	@GetMapping("/{id}")
	public Payment getPaymentById(@PathVariable("id") int id) {
		return vService.getById(id);
	}
	
	@GetMapping
	public List<Payment> getAllPayment(){
		return vService.getAll();
	}
	
	@PostMapping
	public void postPayment(@RequestBody Payment p) {
		vService.create(p);
	}
	
	@PutMapping("/{id}")
	public void putPayment(@PathVariable("id") int id,@RequestBody Payment p) {
		vService.update(id, p);
	}
	
	@DeleteMapping("/{id}")
	public void deletePayment(@PathVariable("id") int id) {
		vService.delete(id);
	}

}