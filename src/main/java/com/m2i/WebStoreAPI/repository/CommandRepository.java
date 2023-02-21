package com.m2i.WebStoreAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.WebStoreAPI.entity.Command;

public interface CommandRepository extends JpaRepository<Command, Integer>{

}
