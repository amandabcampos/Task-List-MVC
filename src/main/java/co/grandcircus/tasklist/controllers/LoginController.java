package co.grandcircus.tasklist.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.grandcircus.tasklist.dao.UserRepository;
import co.grandcircus.tasklist.entity.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private HttpSession sesh;
	
	@RequestMapping("/login")
	public ModelAndView login() {
		//redir.addFlashAttribute("message", "User added");
		return new ModelAndView("login-form");
	}
	
	@PostMapping("/login")
	public ModelAndView loginSubmit(@RequestParam("email") String email,
			@RequestParam("password") String password,
			RedirectAttributes redir) {
		User user = userRepo.findByEmail(email);
		if (user == null || !user.getPassword().equals(password)) {
			return new ModelAndView("login-form", "message", "User not found / Wrong password");
		}
		sesh.setAttribute("user", user); 
		//redir.addFlashAttribute("message", "Logged you in, "+ user.getName()); 
		
		return new ModelAndView("redirect:/user/"+user.getId()); 
		
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(RedirectAttributes redir) {
		sesh.invalidate();  //
		//redir.addFlashAttribute("message", "Logged out successfully");
		return new ModelAndView("redirect:/login");
	}
	
	

}
