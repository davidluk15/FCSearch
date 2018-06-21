package at.fh.swenga.project.controller;

import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.swenga.project.dao.ClubRepository;
import at.fh.swenga.project.model.ClubModel;
import at.fh.swenga.project.model.PlayerModel;

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
	
	
	
	
}
