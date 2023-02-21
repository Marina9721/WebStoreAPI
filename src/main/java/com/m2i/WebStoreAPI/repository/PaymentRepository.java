package com.m2i.WebStoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStoreAPI.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}
