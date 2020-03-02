package co.grandcircus.tasklist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.grandcircus.tasklist.dao.UserRepository;
import co.grandcircus.tasklist.entity.User;

@Controller
@RequestMapping("/user")
public class UserController { 
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/add")
	public ModelAndView addUser() {
		return new ModelAndView("user-add");
	}
	
	@PostMapping("/add")
	public ModelAndView addUser(User user) {
		userRepo.save(user);
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping("/{id}")
	public ModelAndView showUser(@PathVariable("id") User user) {
		return new ModelAndView("user-show", "user", user);
	}
	
	
}
