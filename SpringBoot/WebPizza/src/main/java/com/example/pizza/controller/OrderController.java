package com.example.pizza.controller;

import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pizza.model.CartItem;
import com.example.pizza.model.Order;
import com.example.pizza.model.OrderDetail;
import com.example.pizza.model.Product;
import com.example.pizza.model.User;
import com.example.pizza.service.IOrderDetailService;
import com.example.pizza.service.IOrderService;
import com.example.pizza.service.IProductService;
import com.example.pizza.service.IShoppingCartService;
import com.example.pizza.service.IUserService;


@Controller
@RequestMapping(path = "/order")
public class OrderController {
	
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	IShoppingCartService shoppingCartService;
	
	@Autowired
	IProductService productService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IOrderService orderService;
	
	@Autowired
	IOrderDetailService orderDetailService;
	
	@GetMapping("")
	public String index(Model model) {
		
		Locale lc = new Locale("vi", "VN");
	    NumberFormat nf = NumberFormat.getNumberInstance(lc);
		
		
		model.addAttribute("nf", nf);
		model.addAttribute("items", shoppingCartService.getAllItems());
		model.addAttribute("tongTien", nf.format(shoppingCartService.getAmount()));
		model.addAttribute("soLuongMua", shoppingCartService.getCount());
		return "order";
	}
	
	
	@PostMapping("/add")
	public String add(Model model, @RequestParam("id") int id) {
		
		Optional<User> user = userService.findById(id);
		Order order = new Order();
		order.setNgayLap(Date.valueOf(LocalDate.now()));
		order.setUser(user.get());
		order.setTongTien(shoppingCartService.getAmount());
		orderService.save(order);
		
		Collection<CartItem> items = shoppingCartService.getAllItems();
		for (CartItem item : items) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder(order);
			Optional<Product> product = productService.findById(item.getMaSP());
			int updateAmount = product.get().getSoLuong();
			product.get().setSoLuong(updateAmount-item.getSoLuongMua());
			orderDetail.setProduct(product.get());
			orderDetail.setSoLuong(item.getSoLuongMua());
			orderDetail.setThanhTien(item.getDonGia()*item.getSoLuongMua());
			orderDetail.setDonGia(item.getDonGia());
			orderDetailService.save(orderDetail);
			productService.save(product.get());
		}
		
		shoppingCartService.clear();
		return "redirect:/shop";
	}
}
