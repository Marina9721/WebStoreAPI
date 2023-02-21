package com.m2i.WebStoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStoreAPI.entity.CreditCardPayment;
import com.m2i.WebStoreAPI.repository.CreditCardPaymentRepository;

@Service
public class CreditCardPaymentService {
	
	@Autowired
	CreditCardPaymentRepository repo;
	
	public CreditCardPayment getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<CreditCardPayment> getAll() {
		return repo.findAll();
	}

	public void create(CreditCardPayment c) {
		repo.save(c);
	}

	public void update(int id, CreditCardPayment c) {
		CreditCardPayment payment = repo.findById(id).orElse(null);
		if (c!= null) {
			payment.setAmount(c.getAmount());
			payment.setPaymentDate(c.getPaymentDate());
			payment.setCardNumber(c.getCardNumber());
			payment.setExpirationDate(c.getExpirationDate());

			repo.save(payment);
		}
	}
	
	public void delete(int id) {
		CreditCardPayment creditCardPayment = repo.findById(id).orElse(null);
		if (creditCardPayment!= null) {
			repo.delete(creditCardPayment);
		}	
	}

}
