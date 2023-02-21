package com.m2i.WebStoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStoreAPI.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
}
