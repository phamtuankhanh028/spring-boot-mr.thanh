package com.example.pizza.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;


import com.example.pizza.model.User;
import com.example.pizza.service.IUserService;

@RequestMapping("/user")
@Controller
public class LoginController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(Model model,
			@Valid @ModelAttribute("user") User user, BindingResult result){
		
		
		if(result.hasErrors()) {
			model.addAttribute("user", user);
            return "register";
		}
		
		userService.save(user);
        return "redirect:/user/login";
	}
	
	
	
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("user", new User());
		return "login";
	}
	
	
	@PostMapping("/checkLogin")
	public String checkLogin(Model model,
			@Valid @ModelAttribute("user") User user, BindingResult result){
		
		
		if(result.hasErrors()) {
			model.addAttribute("user", user);
            return "login";
		}
		
		User userCheck = userService.login(user.getTaiKhoan(), user.getMatKhau());
		if(userCheck == null) {
			 return "login";
		}
		
		
		session.setAttribute("userLogin", userCheck);
		
		return "redirect:/shop";
	}
	
	@GetMapping("/logout")
	public String logout() {
		
		session.invalidate();
		return "redirect:/shop";
	}
}
