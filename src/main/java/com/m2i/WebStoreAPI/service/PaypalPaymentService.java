package com.m2i.WebStoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStoreAPI.entity.PaypalPayment;
import com.m2i.WebStoreAPI.repository.PaypalPaymentRepository;

@Service
public class PaypalPaymentService {
	
	@Autowired
	PaypalPaymentRepository repo;
	
	public PaypalPayment getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<PaypalPayment> getAll() {
		return repo.findAll();
	}

	public void create(PaypalPayment p) {
		repo.save(p);
	}
	
	public void update(int id, PaypalPayment p) {
		PaypalPayment payment = repo.findById(id).orElse(null);
		if (p!= null) {
			payment.setAmount(p.getAmount());
			payment.setPaymentDate(p.getPaymentDate());
			payment.setAccountNumber(p.getAccountNumber());
			repo.save(payment);
		}
	}

	public void delete(int id) {
		PaypalPayment payment = repo.findById(id).orElse(null);
		if (payment!= null) {
			repo.delete(payment);
		}	
	}

}
