package com.m2i.WebStoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStoreAPI.entity.Payment;
import com.m2i.WebStoreAPI.repository.PaymentRepository;

@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository repo;
	
	public Payment getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<Payment> getAll() {
		return repo.findAll();
	}

	public void create(Payment p) {
		repo.save(p);
	}
	
	public void update(int id, Payment p) {
		Payment payment = repo.findById(id).orElse(null);
		if (p!= null) {

			repo.save(payment);
		}
	}

	public void delete(int id) {
		Payment payment = repo.findById(id).orElse(null);
		if (payment!= null) {
			repo.delete(payment);
		}	
	}

}
