package at.fh.swenga.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import at.fh.swenga.project.dao.PlayerRepository;
import at.fh.swenga.project.model.PlayerModel;


@Controller 
public class PlayerController {

	@Autowired
	PlayerRepository playerRepository;
	
	@RequestMapping(value = { "/", "index" })
	public String index(Model model) {
		
		return "index";
	}
	

	
	@RequestMapping(value = { "/listPlayers" })
	public String showAllPlayers(Model model) {
			
		
		List<PlayerModel> playerModel = playerRepository.findAll();
		model.addAttribute("playerModel", playerModel);
		
	
		return "listPlayers";
	}
	
	
	@RequestMapping(value = { "/find" })
	public String find(Model model, @RequestParam String searchString, @RequestParam String searchType) {
		List<PlayerModel> players = null;
		int count=0;

		switch (searchType) {
		case "query1":
			//employees = employeeRepository.findAll();
			break;
		case "query2":
			//employees = employeeRepository.findByLastName(searchString);
			break;
		case "query3":
			//employees = employeeRepository.findByFirstName(searchString);
			break;
		case "query4":
			//employees = employeeRepository.findByFirstOrLastName(searchString);
			break;
		case "query5":
			//employees = employeeRepository.findByFirstOrLastNameZwei(searchString);
			break;
		case "query6":
			//count = employeeRepository.countByLastName(searchString);
			break;
		case "query7":
			//employees = employeeRepository.removeByLastName(searchString);
			break;
		case "query8":
			//employees = employeeRepository.;
			break;
		case "query9":
			//employees = employeeRepository.findByLastNameContainingIgnoreCaseOrFirstNameContainingIgnoreCase(searchString,searchString);
			break;
		case "query10":
			//employees = employeeRepository.;
			break;
		case "query11":
			//employees = employeeRepository.;
			break;
		case "query12":
			//employees = employeeRepository.;
			break;
		case "query13":
			//employees = employeeRepository.;
			break;
		case "query14":
			//employees = employeeRepository.;
			break;
		case "query15":
			//employees = employeeRepository.;
			break;

		default:
			players = playerRepository.findAll();
		}
		
		model.addAttribute("players", players);

		if (players!=null) {
			model.addAttribute("count", players.size());			
		}
		else {
			model.addAttribute("count", count);				
		}
		return "index";
	}
	
	
	
	@RequestMapping(value = {"addPlayer"})
	public String showAddPlayer(Model model) {
		
		return "editPlayer";
	}
	
	@RequestMapping(value = {"editPlayer"})
	public String showEditPlayer(Model model) {
		
		return "editPlayer";
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
