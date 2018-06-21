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
import at.fh.swenga.project.model.ClubModel;

@Controller
public class ClubController {

	@Autowired
	ClubRepository clubRepository;
	
	@RequestMapping(value = { "/", "clubList" })
	public String index(Model model) {
		List<ClubModel> clubs = clubRepository.findAll();
		model.addAttribute("clubs", clubs);
		model.addAttribute("count", clubs.size());
		return "index";
	}
	
	@GetMapping("/addClub")
	public String showAddClubForm(Model model) {
		return "editClub";
	}

	// Spring 4: @RequestMapping(value = "/addEmployee", method =
	// RequestMethod.POST)
	@PostMapping("/addClub")
	public String addClub(@Valid ClubModel newClubModel, BindingResult bindingResult, Model model) {

		// Any errors? -> Create a String out of all errors and return to the
		// page
		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errorMessage += fieldError.getField() + " is invalid<br>";
			}
			model.addAttribute("errorMessage", errorMessage);

			// Multiple ways to "forward"
			return "forward:/listClubs";
		}

		// Look for employee in the List. One available -> Error
		ClubModel club = clubRepository.getClubByClubId(newClubModel.getClubId());

		if (club != null) {
			model.addAttribute("errorMessage", "Dieser Verein wurde bereits angelegt!<br>");
		} else {
			clubRepository.addClub(newClubModel);
			model.addAttribute("message", "Verein " + newClubModel.getClubId() + " wurde hinzugefügt.");
		}

		return "forward:/listClubs";
	}

	// Spring 4: @RequestMapping(value = "/editEmployee", method =
	// RequestMethod.GET)
	@GetMapping("/editClub")
	public String showChangeClubForm(Model model, @RequestParam int clubId) {

		ClubModel club = clubRepository.getClubByClubId(clubId);

		if (club != null) {
			model.addAttribute("club", club);
			return "editClub";
		} else {
			model.addAttribute("errorMessage", "Der Verein mit der Nummer " + clubId + " konnte nicht gefunden werden.");
			return "forward:/listClubs";
		}
	}

	// Spring 4: @RequestMapping(value = "/editEmployee", method =
	// RequestMethod.POST)
	@PostMapping("/editClub")
	public String editClub(@Valid ClubModel changedClubModel, BindingResult bindingResult, Model model) {

		// Any errors? -> Create a String out of all errors and return to the
		// page
		if (bindingResult.hasErrors()) {
			String errorMessage = "";
			for (FieldError fieldError : bindingResult.getFieldErrors()) {
				errorMessage += fieldError.getField() + " is invalid<br>";
			}
			model.addAttribute("errorMessage", errorMessage);
			return "forward:/listClubs";
		}

		// Get the employee we want to change
		ClubModel club = clubRepository.getClubByClubId(changedClubModel.getClubId());

		if (club == null) {
			model.addAttribute("errorMessage", "Dieser Verein wurde noch nicht angelegt!<br>");
		} else {
			// Change the attributes
			club.setClubId(changedClubModel.getClubId());
			club.setClubName(changedClubModel.getClubName());
			club.setLocation(changedClubModel.getLocation());
			club.setCoach(changedClubModel.getCoach());
			club.setTrainingDays(changedClubModel.getTrainingDays());
			club.setTrainingTime(changedClubModel.getTrainingTime());
			club.setSponsor(changedClubModel.getSponsor());
			club.setFoundingYear(changedClubModel.getFoundingYear());

			// Save a message for the web page
			model.addAttribute("message", "Verein " + changedClubModel.getClubId() + " wurde geändert.");
		}

		return "forward:/listClubs";
	}

	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";

	}
	
	
}
