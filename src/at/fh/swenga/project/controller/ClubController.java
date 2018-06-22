
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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.project.dao.ClubRepository;
import at.fh.swenga.project.model.ClubModel;

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


	@RequestMapping(value = {"editClub"})
	public String editClub(Model model, @RequestParam int clubId, ClubModel clubModel) {

		Optional<ClubModel> clubOptional = clubRepository.findById(clubId);
		ClubModel club = clubOptional.get();
		model.addAttribute("club", club);
	
		
		return "addEditClub";
	}

	@RequestMapping(value = "editClub", method = RequestMethod.POST)
	public String editClub(@Valid ClubModel newClubModel, BindingResult bindingResult, Model model,
			@RequestParam("clubId") int clubId) {

		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errorMessage += fieldError.getField() + " is invalid<br>";
			}
			model.addAttribute("errorMessage", errorMessage);
			return "listClubs";
		}

		else {
		Optional<ClubModel> clubOptional = clubRepository.findById(newClubModel.getClubId());

		ClubModel club = clubOptional.get();

		club.setClubName(newClubModel.getClubName());
		club.setLocation(newClubModel.getLocation());
		club.setTrainingDays(newClubModel.getTrainingDays());
		club.setCoach(newClubModel.getCoach());
		club.setTrainingTime(newClubModel.getTrainingTime());
		club.setSponsor(newClubModel.getSponsor());
		club.setFoundingYear(newClubModel.getFoundingYear());
		club.setClubAdress(newClubModel.getClubAdress());

		clubRepository.save(club);
		return "forward:listClubs";
		}

		}
	
	
	@RequestMapping("/deleteClub")
	public String deleteClub(Model model, @RequestParam int clubId) {
		clubRepository.deleteById(clubId);;

		return "forward:listClubs";
	}
	
	
	@RequestMapping("/fillClubsList")
	@Transactional
	public String fillData(Model model) {

		DataFactory df = new DataFactory();
		

		
		
		for(int i=0;i<100;i++) {
			if (i%10==0) {
				
			
			
			String[] clubs = {"LOK Graz", "Die Überspitzen","Eggenberg 04", "Vinko-Verpackung","Club Graz 05", "Oranje","Eggenberg 04","FC Fortuna","ATV Graz","Eggenberg 04","LOK Graz","Peggau Calcio 13","Peggau Calcio 13", "Club Graz 05"};
			String[] days = {"Montag","Dienstag","Mittwoch","Donnerstag","Freitag","Samstag","Sonntag"};
			String[] time = {"17:00","17:30","18:00","18:30","19:00","19:30","20:00"};
			String[] sponsoren = {"Heineken","Puntigamer","Jägermeister","Murauer","Gösser","Jägermeister-Winterkräuter","Egger-Märzen"};
			String[] maila = {"test@gmail.com"};




			
			ClubModel clubModel = new ClubModel(df.getItem(clubs),df.getCity(),df.getItem(days),df.getLastName(),df.getItem(time),df.getItem(sponsoren),df.getNumberBetween(1888, 2005),df.getItem(maila));
			
	
			clubRepository.save(clubModel);
		}
	
		
	}
		return "forward:listClubs";
	
	}
	//########################################
	
	
	@RequestMapping(value = { "/findClubs" })
	public String find(Model model, @RequestParam String searchString, @RequestParam String searchType) {
		List<ClubModel> clubs = null;
		int count = 0;

		switch (searchType) {
		case "query1":
			clubs = clubRepository.findAll();
			break;
		case "query2":
			clubs = clubRepository.findByLocation(searchString);
			break;
		case "query3":
			clubs = clubRepository.findByTrainingDays(searchString);
			break;
		case "query4":
			clubs = clubRepository.findByTrainingTime(searchString);
			break;
	
		default:
			clubs = clubRepository.findAll();
		}

		model.addAttribute("clubs", clubs);

		if (clubs != null) {
			model.addAttribute("count", clubs.size());
		} else {
			model.addAttribute("count", count);
		}
		return "listClubs";
	}
	
	//#############################################

	
	@RequestMapping(value = { "contact" })
	public String register(Model model) {
		
		return "contact";
}

	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";

	}
	
	
}
