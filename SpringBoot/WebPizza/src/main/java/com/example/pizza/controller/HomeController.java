package com.example.pizza.controller;

import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pizza.service.IProductService;
import com.example.pizza.service.IShoppingCartService;


@Controller
public class HomeController {

	
	@Autowired
	IShoppingCartService shoppingCartService;
	
	@Autowired
	IProductService productService;
	
	
	@RequestMapping(path = "/")
	public String index(Model model) {
				
		Locale lc = new Locale("vi", "VN");
	    NumberFormat nf = NumberFormat.getNumberInstance(lc);
	    
	    
	    model.addAttribute("nf", nf);
		model.addAttribute("topSeller", productService.findTopSeller(10));
		model.addAttribute("soLuongMua", shoppingCartService.getCount());
		return "index";
	}
}
