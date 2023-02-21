package com.m2i.WebStoreAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.WebStoreAPI.entity.Article;
import com.m2i.WebStoreAPI.entity.Command;
import com.m2i.WebStoreAPI.entity.CommandLine;
import com.m2i.WebStoreAPI.entity.User;
import com.m2i.WebStoreAPI.service.ArticleService;
import com.m2i.WebStoreAPI.service.CommandLineService;
import com.m2i.WebStoreAPI.service.CommandService;
import com.m2i.WebStoreAPI.service.UserService;

@RestController
public class Controller {
	
	@Autowired
	ArticleService aService;
	
	@Autowired
	CommandService cService;
	
	@Autowired
	CommandLineService clService;
	
	@Autowired
	UserService uService;
	
	
	@PostMapping("/newArticle")
	public void addArticleToCommand(@RequestParam("id") int id, @RequestBody Article a) {
		List<CommandLine> listCommandLines = clService.getAll();
		CommandLine cl = null;
		for(CommandLine commandline : listCommandLines) {
			if(commandline.getCommand().getId() == id) {
				cl = commandline;
				break;
			}
		}
		cl.setArticle(a);
		cl.setQuantity(cl.getQuantity()+1);
		
	}
	
	
	@GetMapping("/getArticles/{id}")
	public List<Article> getArticlesByIdCommand(@PathVariable int id){
		List<Article> listArticles = new ArrayList<>();
		List<CommandLine> listCommandLines = clService.getAll();
		for(CommandLine commandline : listCommandLines) {
			if(commandline.getCommand().getId() == id) {
				listArticles.add(commandline.getArticle());
			}
		}
		return listArticles;
	}
	
	
	@GetMapping("/user/total/{idUser}")
	public double totalAmountByUser(@PathVariable int idUser) {

		User u = uService.getById(idUser);
		List<Command> listCommands = u.getCommands();
		double somme = 0.0;
		
		for(Command command : listCommands) {
			somme = somme + command.getPayment().getAmount();
		}
		return somme;
	}
}
