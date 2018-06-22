package at.fh.swenga.project.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import at.fh.swenga.project.dao.PlayerRepository;
import at.fh.swenga.project.model.PlayerModel;

@Controller
public class PlayerController {

	@Autowired
	PlayerRepository playerRepository;

	// @RequestMapping(value = { "/", "index" })
	// public String index(Model model) {

	// return "index";
	// }

	@RequestMapping(value = { "/listPlayers" })
	public String listPlayers(Model model) {
		List<PlayerModel> players = playerRepository.findAll();
		model.addAttribute("players", players);
		return "listPlayers";

	}

	@RequestMapping(value = { "/find" })
	public String find(Model model, @RequestParam String searchString, @RequestParam String searchType) {
		List<PlayerModel> players = null;
		int count = 0;

		switch (searchType) {
		case "query1":
			players = playerRepository.findAll();
			break;
		case "query2":
			players = playerRepository.findByPosition(searchString);
			break;
		case "query3":
			players = playerRepository.findByAvailabelTrainingDays(searchString);
			break;
		case "query4":
			players = playerRepository.findByAge(Integer.parseInt(searchString));
			break;
		case "query5":
			players = playerRepository.findByLastName(searchString);
			break;
		case "query6":
			players = playerRepository.findByFirstName(searchString);
			break;
		

		default:
			players = playerRepository.findAll();
		}

		model.addAttribute("players", players);

		if (players != null) {
			model.addAttribute("count", players.size());
		} else {
			model.addAttribute("count", count);
		}
		return "listPlayers";
	}

	@RequestMapping(value = { "addPlayer" }, method = RequestMethod.GET)
	public String showAddPlayer(Model model) {

		List<PlayerModel> players = playerRepository.findAll();
		model.addAttribute("players", players);

		return "addEditPlayer";
	}

	@RequestMapping(value = "addPlayer", method = RequestMethod.POST)
	public String addPlayer(PlayerModel newPlayerModel, BindingResult bindingResult, Model model) {

		// System.out.println(playerModelForm.getFirstName());
		if (bindingResult.hasErrors()) {
			model.addAttribute("errorMessage", "Ein Fehler ist aufgetreten");

			return "listPlayers";
		}

		playerRepository.save(newPlayerModel);
		return listPlayers(model);

	}

	@RequestMapping(value = {"editPlayer"})
	public String editPlayer(Model model, @RequestParam int playerId, PlayerModel playerModel) {

		Optional<PlayerModel> playerOptional = playerRepository.findById(playerId);
		PlayerModel player = playerOptional.get();
		model.addAttribute("player", player);
	
		
		return "addEditPlayer";
	}

	@RequestMapping(value = "editPlayer", method = RequestMethod.POST)
	public String editPlayer(@Valid PlayerModel newPlayerModel, BindingResult bindingResult, Model model,
			@RequestParam("playerId") int playerId) {

		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errorMessage += fieldError.getField() + " is invalid<br>";
			}
			model.addAttribute("errorMessage", errorMessage);
			return "listPlayers";
		}

		else {
		Optional<PlayerModel> playerOptional = playerRepository.findById(newPlayerModel.getPlayerId());

		PlayerModel player = playerOptional.get();

		player.setFirstName(newPlayerModel.getFirstName());
		player.setLastName(newPlayerModel.getLastName());
		player.setPosition(newPlayerModel.getPosition());
		player.setAge(newPlayerModel.getAge());
		player.setFirstName(newPlayerModel.getFirstName());
		player.setAvailabelTrainingDays(newPlayerModel.getAvailabelTrainingDays());
		player.setMailAdress(newPlayerModel.getMailAdress());

		playerRepository.save(player);
		return "forward:listPlayers";
		}

		}
	
	
	@RequestMapping("/fillPlayerList")
	@Transactional
	public String fillData(Model model) {

		DataFactory df = new DataFactory();
		

		
		
		for(int i=0;i<100;i++) {
			if (i%10==0) {
				
			
			
			String[] position = {"St\u00fcrmer","Innenverteidiger","Torwart","Rechter Verteidiger","Linker Verteidiger","Defensives Mittelfeld","Offensives Mittelfeld","Rechtsaußen","Linksaußen"};
			String[] days = {"Montag","Dienstag","Mittwoch","Donnerstag","Freitag","Samstag","Sonntag"};
			String[] mailAdress = {"test@gmail.com"};
			
			PlayerModel playerModel = new PlayerModel(df.getFirstName(),df.getLastName(),df.getItem(position),df.getNumberBetween(15, 60),df.getItem(days),df.getItem(mailAdress));
	
			playerRepository.save(playerModel);
		}
	
		
	}
		return "forward:listPlayers";
	
	}
	
	


	@RequestMapping("/deletePlayer")
	public String deletePlayer(Model model, @RequestParam int id) {
		playerRepository.deleteById(id);

		return "forward:listPlayers";
	}

	@RequestMapping(value = { "login" })
	public String login(Model model) {

		return "login";
	}

	@RequestMapping(value = { "register" })
	public String register(Model model) {

		return "register";
	}

}