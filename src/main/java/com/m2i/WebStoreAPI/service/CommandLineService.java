package com.m2i.WebStoreAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStoreAPI.entity.CommandLine;
import com.m2i.WebStoreAPI.repository.CommandLineRepository;

@Service
public class CommandLineService {
	
	@Autowired
	CommandLineRepository repo;
	
	public void create(CommandLine c) {
		repo.save(c);
	}
	
	public CommandLine getById(int id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<CommandLine> getAll(){
		return repo.findAll();
	}
	
	public void update(int id, CommandLine c) {
		CommandLine commandline = repo.findById(id).orElse(null);
		if(c != null) {
			commandline.setQuantity(c.getQuantity());
			repo.save(commandline);
		}
	}
	
	public void delete(int id) {
		CommandLine commandline = repo.findById(id).orElse(null);
		if(commandline != null) {
			repo.delete(commandline);
		}
	}

}
