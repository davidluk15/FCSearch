package at.fh.swenga.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import at.fh.swenga.project.dao.UserDao;
import at.fh.swenga.project.dao.UserRoleDao;
import at.fh.swenga.project.model.UserModel;
import at.fh.swenga.project.model.UserRoleModel;

@Controller
public class SecurityController {
 
	@Autowired
	UserDao userDao;
 
	@Autowired
	UserRoleDao userRoleDao;
	
	@RequestMapping(value = { "/", "index" })
	public String index(Model model) {
		
		return "index";
	}
 
	@RequestMapping("/fillUsers")
	@Transactional
	public String fillData(Model model) {
 
		UserRoleModel adminRole = userRoleDao.getRole("ROLE_ADMIN");
		if (adminRole == null)
			adminRole = new UserRoleModel("ROLE_ADMIN");
 
		UserRoleModel playerRole = userRoleDao.getRole("ROLE_PLAYER");
		if (playerRole == null)
			playerRole = new UserRoleModel("ROLE_PLAYER");
		
		UserRoleModel clubRole = userRoleDao.getRole("ROLE_CLUB");
		if (clubRole == null)
			clubRole = new UserRoleModel("ROLE_CLUB");
 
		UserModel admin = new UserModel("admin", "password", true);
		admin.encryptPassword();
		admin.addUserRole(playerRole);
		admin.addUserRole(clubRole);
		admin.addUserRole(adminRole);
		userDao.persist(admin);
 
		UserModel player = new UserModel("player", "password", true);
		player.encryptPassword();
		player.addUserRole(playerRole);
		userDao.persist(player);
		
		UserModel club = new UserModel("club", "password", true);
		club.encryptPassword();
		club.addUserRole(clubRole);
		userDao.persist(club);
 
		return "forward:login";
	}
 
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex) {
 
		return "error";
 
	}
}
