package org.drewps.web;

import javax.validation.Valid;

import org.drewps.domain.User;
import org.drewps.manager.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	private UserManager userManager;
	
	public UserController() { }
	
	@RequestMapping(value = "/secured/admin/users", method = { RequestMethod.GET, RequestMethod.POST })
	public String displayUsers(Model model) {
		model.addAttribute("users", userManager.getUsers());
		
		return "users";
	}
	
	@RequestMapping(value = "/secured/admin/user/new", method = RequestMethod.GET)
	public String displayNewUserForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roleList", userManager.getRoles());
		
		return "usersform";
	}
	
	@RequestMapping(value = "/secured/admin/user/new", method = RequestMethod.POST)
	public String addUserForm(@Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("roleList", userManager.getRoles());
			
			return "usersform";
		}
		
		userManager.addUser(user);
		return "redirect:/webapp/secured/admin/users";
	}
	
	@RequestMapping(value = "/secured/admin/user/update/{username}", method = RequestMethod.GET)
	public String displayUpdateUserForm(@PathVariable String username, Model model) {
		User user = userManager.findUser(username);
		model.addAttribute("user", user);
		model.addAttribute("roleList", userManager.getRoles());
		
		return "usersform";
	}
	
	@RequestMapping(value = "/secured/admin/user/update/{usernamae}", method = RequestMethod.POST)
	public String updateUserForm(@Valid User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("roleList", userManager.getRoles());
			
			return "usersform";
		}
		
		userManager.updateUser(user);
		return "redirect:/webapp/secured/admin/users";
	}
	
	@RequestMapping(value = "/secured/admin/user/remove/{username}", method = RequestMethod.GET)
	public String removeUserForm(@PathVariable String username) {
		User user = userManager.findUser(username);
		userManager.removeUser(user);
		
		return "redirect:/webapp/secured/admin/users";
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
}