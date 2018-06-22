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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.project.dao.ClubRepository;
import at.fh.swenga.project.dao.PlayerRepository;
import at.fh.swenga.project.model.ClubModel;
import at.fh.swenga.project.model.PlayerModel;

@Controller
public class ClubController {

	@Autowired
	ClubRepository clubRepository;
	
	
	@RequestMapping(value = { "/listClubs" })
	public String listClubs(Model model) {
	List<ClubModel> clubs = clubRepository.findAll();
	model.addAttribute("clubs", clubs);
	return "listClubs";
	
	}
	
	
	@RequestMapping(value = {"addClub"}, method = RequestMethod.GET)
	public String showAddPlayer(Model model) {
		
		List<ClubModel> clubs = clubRepository.findAll();
		model.addAttribute("clubs", clubs);
				
		return "addEditClub";
	}
	
	
	@RequestMapping(value = "addClub", method = RequestMethod.POST)
    public String addEntry( ClubModel newClubModel, BindingResult bindingResult, Model model) 
	{
		
		//System.out.println(playerModelForm.getFirstName());
        if (bindingResult.hasErrors()) {
            return "listPlayers";
        }
        
      clubRepository.save(newClubModel);
      return listClubs(model);
     
    }
	
	@RequestMapping(value = { "contact" })
	public String register(Model model) {
		
		return "contact";
}

	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";

	}
	
	
}
