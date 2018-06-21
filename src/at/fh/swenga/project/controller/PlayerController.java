package at.fh.swenga.project.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import at.fh.swenga.project.dao.ClubRepository;
import at.fh.swenga.project.dao.PlayerRepository;
import at.fh.swenga.project.model.ClubModel;
import at.fh.swenga.project.model.PlayerModel;


@Controller
public class PlayerController {

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	ClubRepository clubRepository;

	@RequestMapping(value = { "/", "list" })
	public String index(Model model) {
		List<PlayerModel> players = playerRepository.findAll();
		model.addAttribute("players", players);
		model.addAttribute("count", players.size());
		return "index";
	}
	
	@RequestMapping(value = { "/getPage" })
	public String getPage(Pageable page,Model model) {
		Page<PlayerModel> playersPage = playerRepository.findAll(page);
		model.addAttribute("playersPage", playersPage);
		model.addAttribute("players", playersPage.getContent());
		model.addAttribute("count", playersPage.getTotalElements());
		return "index";
	}

	@RequestMapping(value = { "/find" })
	public String find(Model model, @RequestParam String searchString, @RequestParam String searchType) {
		List<PlayerModel> players = null;
		int count=0;

		switch (searchType) {
		case "query1":
			players = playerRepository.findByLastName(searchString);
			break;
		case "query2":
			//employees = employeeRepository.;
			break;
		case "query3":
			//employees = employeeRepository.;
			break;
		case "query4":
			//employees = employeeRepository.;
			break;
		case "query5":
			//employees = employeeRepository.;
			break;
		case "query6":
			//employees = employeeRepository.;
			break;
		case "query7":
			//employees = employeeRepository.;
			break;
		case "query8":
			//employees = employeeRepository.;
			break;
		case "query9":
			//employees = employeeRepository.;
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

	@RequestMapping(value = { "/findById" })
	public String findById(@RequestParam("playerId") PlayerModel e, Model model) {
		if (e!=null) {
			List<PlayerModel> players = new ArrayList<PlayerModel>();
			players.add(e);
			model.addAttribute("players", players);
		}
		return "index";
	}



	@RequestMapping("/fillEmployeeList")
	@Transactional
	public String fillData(Model model) {

		DataFactory df = new DataFactory();
		
		ClubModel club = null;
		
		for(int i=0;i<100;i++) {
			if (i%10==0) {
				String clubName=df.getBusinessName();
				club=clubRepository.findByClubName(clubName);
				if (club==null) {
					club = new ClubModel(clubName, clubName, clubName, clubName,clubName, clubName,1990 );
				}
			}
			
			
			
			PlayerModel playerModel = new PlayerModel(df.getFirstName(),df.getLastName(), df.getFirstName(), 2, df.getFirstName());
			playerModel.setClub(club);
			playerRepository.save(playerModel);
		}
	
		return "forward:list";
	}
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/delete")
	public String deleteData(Model model, @RequestParam int id) {
		playerRepository.deleteById(id);

		return "forward:list";
	}

	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {

		return "error";

	}
}
