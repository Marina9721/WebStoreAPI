package com.m2i.WebStoreAPI.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
		/*
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
		*/
		Command command = cService.getById(id);
		aService.create(a);
		CommandLine cl = new CommandLine(1, a, command);
		clService.create(cl);
		
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
	
	
	@GetMapping("/commande/ca")
	public List<Command> commandsBetweenDates(@RequestParam("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut, @RequestParam("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin){
		List<Command> allCommands = new ArrayList<>();
		for(Command command : allCommands) {
			if(command.getCommandDate().after(dateDebut) && command.getCommandDate().before(dateFin)) {
				allCommands.add(command);
			}
		}
		return allCommands;
	}
	
	@GetMapping("/articlesamebrand")
	public List<Article> articlesSameBrand(@RequestParam("brand") String brand){
		List<Article> listArticles = new ArrayList<>();
		for(Article article : aService.getAll()) {
			if(article.getBrand().equals(brand)) {
				listArticles.add(article);
			}
		}
		return listArticles;
	}
	
	
	@PostMapping("/article/list")
	public void addListArticles(@RequestBody List<Article> listArticles) {
		for(Article article : listArticles) {
			aService.create(article);
		}
		
	}
	
	
	@GetMapping("/usercity")
	public List<User> usersInSameCity(@RequestParam("city") String city){
		List<User> allUsers = new ArrayList<>();
		for(User user : allUsers) {
			if(user.getUserInformations().getCity().equals(city)) {
				allUsers.add(user);
			}
		}
		return allUsers;
	}
	
	
	@GetMapping("/usercommand")
	public List<User> commandBeforeDate(@RequestParam("city") String city, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
		List<User> allUsers = new ArrayList<>();
		for (User user : usersInSameCity(city)) {
			for(Command command :user.getCommands()) {
				if(command.getCommandDate().before(date)) {
					allUsers.add(user);
					break;
				}
			}
		}
		return allUsers;
	}
	
	
	
	/*
	 	1. POST /newArticle?idCommande={id} -> Ajoute un article dans la commande {idCommande}
		2. GET  /getArticles/{idCommande} -> Envoie tous les articles de la commande à l'ID {idCommande}
		3. GET  /user/total/{idUser} -> Envoie le montant total payé par un utilisateur sur le site
		4. GET  /commande/ca {date_debut:"yyyy-mm-dd", date_fin:"yyyy-mm-dd"} -> Envoie la somme de toutes les commandes entre la date de début et date de fin
		5. GET  /article?brand={marque} -> Envoie tous les article de la {marque}
		6. POST /article/list -> Ajoute une liste d'articles entière en une seule requete
		7. GET  /user?city={ville} -> Envoie tout les utilisateurs d'une {ville}
		8. GET  /user/?city={ville}&duree={date} -> Envoie tout les utilisateurs d'une {ville} ayant commandé il y a moins de {date}
	 */
}
