package at.fh.swenga.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.project.dao.ClubRepository;
import at.fh.swenga.project.dao.PlayerRepository;
import at.fh.swenga.project.model.ClubModel;
import at.fh.swenga.project.model.PlayerModel;

@Controller
public class ClubController {

	@Autowired
	ClubRepository clubRepository;
	
	@RequestMapping(value = { "/", "index" })
	public String index(Model model) {
		
		return "index";
	}
	
	@RequestMapping(value = { "/listClubs" })
	public String showAllClubs(Model model) {
			
		
		List<ClubModel> clubModel = clubRepository.findAll();
		model.addAttribute("clubModel", clubModel);
		
	
		return "listClubs";
	}

	@RequestMapping(value = {"addClub"})
	public String showAddClub(Model model) {
		
		return "editClub";
	}
	
	@RequestMapping("/deleteClub")
	public String deleteClub(Model model, @RequestParam int id) {
		clubRepository.deleteById(id);

		return "forward:listClubs";
	}
	
	@RequestMapping(value = { "login" })
	public String login(Model model) {
		
		return "login";
	}
	
	@RequestMapping(value = { "register" })
	public String register(Model model) {
		
		return "register";
	}

	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";

	}
	
	
}
