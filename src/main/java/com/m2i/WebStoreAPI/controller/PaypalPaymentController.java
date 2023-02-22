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

import com.m2i.WebStoreAPI.entity.PaypalPayment;
import com.m2i.WebStoreAPI.service.PaypalPaymentService;

@RestController
@RequestMapping("/paypalpayment")
public class PaypalPaymentController {
	
	@Autowired
	PaypalPaymentService pService;
	
	@GetMapping("/fake")
	public PaypalPayment fakePaypalPayment() {
		PaypalPayment pp = new PaypalPayment();
		pService.create(pp);
		return pp;
	}
	
	@GetMapping("/{id}")
	public PaypalPayment getPaypalPaymentById(@PathVariable("id") int id) {
		return pService.getById(id);
	}
	
	@GetMapping
	public List<PaypalPayment> getAllPaypalPayments(){
		return pService.getAll();
	}
	
	@PostMapping
	public void postPaypalPayment(@RequestBody PaypalPayment p) {
		pService.create(p);
	}
	
	@PutMapping("/{id}")
	public void putPaypalPayment(@PathVariable("id") int id,@RequestBody PaypalPayment p) {
		pService.update(id, p);
	}
	
	@DeleteMapping("/{id}")
	public void deletePaypalPayment(@PathVariable("id") int id) {
		pService.delete(id);
	}

}
