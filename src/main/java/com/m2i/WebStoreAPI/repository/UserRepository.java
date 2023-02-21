package com.m2i.WebStoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStoreAPI.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
