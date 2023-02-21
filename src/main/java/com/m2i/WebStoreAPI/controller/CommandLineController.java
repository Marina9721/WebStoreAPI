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

import com.m2i.WebStoreAPI.entity.CommandLine;
import com.m2i.WebStoreAPI.service.CommandLineService;

@RestController
@RequestMapping("/commandline")
public class CommandLineController {
	
	@Autowired
	CommandLineService clService;
	
	@GetMapping("/fake")
	public CommandLine fakeCommandLine() {
		CommandLine cl = new CommandLine();
		clService.create(cl);
		return(cl);
	}

	@GetMapping("/{id}")
	public CommandLine getCommandLineById(@PathVariable int id) {
		return clService.getById(id);
	}
	
	@GetMapping
	public List<CommandLine> getAllCommandLines(){
		return clService.getAll();
	}
	
	@PostMapping
	public void postCommandLine(@RequestBody CommandLine cl) {
		clService.create(cl);
	}
	
	@PutMapping("/{id}")
	public void putCommandLine(@PathVariable int id, @RequestBody CommandLine cl) {
		clService.update(id, cl);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCommandLine(@PathVariable int id) {
		clService.delete(id);
	}
}
