package at.fh.swenga.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.swenga.project.dao.UserRepository;
import at.fh.swenga.project.dao.UserRoleRepository;
import at.fh.swenga.project.model.UserModel;
import at.fh.swenga.project.model.UserRoleModel;

@Controller
public class SecurityController {
 
	@Autowired
	UserRepository userRepository;
 
	@Autowired
	UserRoleRepository userRoleRepository;
 
	@RequestMapping("/fillUsers")
	@Transactional
	public String fillData(Model model) {
 
		UserRoleModel adminRole = userRoleRepository.getRole("ROLE_ADMIN");
		if (adminRole == null)
			adminRole = new UserRoleModel("ROLE_ADMIN");
 
		UserRoleModel playerRole = userRoleRepository.getRole("ROLE_PLAYER");
		if (playerRole == null)
			playerRole = new UserRoleModel("ROLE_PLAYER");
		
		UserRoleModel clubRole = userRoleRepository.getRole("ROLE_CLUB");
		if (clubRole == null)
			clubRole = new UserRoleModel("ROLE_CLUB");
 
		UserModel admin = new UserModel("admin", "password", true);
		admin.encryptPassword();
		admin.addUserRole(playerRole);
		admin.addUserRole(clubRole);
		admin.addUserRole(adminRole);
		userRepository.persist(admin);
 
		UserModel player = new UserModel("player", "password", true);
		player.encryptPassword();
		player.addUserRole(playerRole);
		userRepository.persist(player);
		
		UserModel club = new UserModel("club", "password", true);
		club.encryptPassword();
		club.addUserRole(clubRole);
		userRepository.persist(club);
 
		return "forward:login";
	}
 
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {
 
		return "error";
 
	}
}
