package com.m2i.WebStoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStoreAPI.entity.UserInformations;

public interface UserInformationsRepository extends JpaRepository<UserInformations, Integer>{
	
}
