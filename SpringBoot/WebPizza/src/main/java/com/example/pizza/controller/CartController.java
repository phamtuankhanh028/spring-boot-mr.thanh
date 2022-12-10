package com.example.pizza.controller;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.pizza.model.CartItem;
import com.example.pizza.model.Product;
import com.example.pizza.service.IProductService;
import com.example.pizza.service.IShoppingCartService;
import com.example.pizza.service.ProductService;

@Controller
@RequestMapping("/shopping-cart")
public class CartController {
	
	
	@Autowired
	IProductService productService;
	
	@Autowired
	IShoppingCartService shoppingCartService;
	
	
	@GetMapping("/view")
	public String index(Model model) {
		
		Locale lc = new Locale("vi", "VN");
	    NumberFormat nf = NumberFormat.getNumberInstance(lc);
		
		model.addAttribute("nf", nf);
		model.addAttribute("items", shoppingCartService.getAllItems());
		model.addAttribute("tongTien", nf.format(shoppingCartService.getAmount()));
		model.addAttribute("soLuongMua", shoppingCartService.getCount());
		return "cart";
	}
	
	
	@GetMapping("/add/{maSP}")
	public String addCart(@PathVariable("maSP") Integer maSP) {
		
		Optional<Product> product = productService.findById(maSP);
		if(product != null) {
			CartItem item = new CartItem();
			item.setMaSP(product.get().getMaSP());
			item.setTenSP(product.get().getTenSP());
			item.setDonGia(product.get().getDonGia());
			item.setHinhAnh(product.get().getHinhAnh());
			item.setSoLuong(product.get().getSoLuong());
			shoppingCartService.add(item);
		}
		return "redirect:/shopping-cart/view";
	}
	
	@GetMapping("/addByDetail")
	public String addCartByDetail(@RequestParam("maSP") Integer maSP, @RequestParam("soLuongMua") int soLuongMua) {
		
		Optional<Product> product = productService.findById(maSP);
		if(product != null) {
			CartItem item = new CartItem();
			item.setMaSP(product.get().getMaSP());
			item.setTenSP(product.get().getTenSP());
			item.setDonGia(product.get().getDonGia());
			item.setHinhAnh(product.get().getHinhAnh());
			item.setSoLuong(product.get().getSoLuong());
			item.setSoLuongMua(soLuongMua);
			shoppingCartService.addByDetail(item, soLuongMua);
		}
		return "redirect:/shopping-cart/view";
	}
	
	
	@GetMapping("/delete/{maSP}")
	public String deleteItem(@PathVariable("maSP") Integer maSP) {
		shoppingCartService.remove(maSP);
		return "redirect:/shopping-cart/view";
	}
	
	
	@GetMapping("/update")
	public String updateItem(@RequestParam("maSP") Integer maSP, @RequestParam("soLuong") int soLuong) { //@RequestParam("maSP")  dùng cho get post
		shoppingCartService.update(maSP, soLuong);
		return "redirect:/shopping-cart/view";
	}
	
	@GetMapping("/clear")
	public String clearCart() {
		shoppingCartService.clear();
		return "redirect:/shopping-cart/view";
	}
}
