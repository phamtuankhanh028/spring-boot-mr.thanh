package com.example.pizza.controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.pizza.model.Category;
import com.example.pizza.model.Product;
import com.example.pizza.repository.ProductRepository;
import com.example.pizza.service.ICategoryService;
import com.example.pizza.service.IProductService;
import com.example.pizza.service.IShoppingCartService;
import com.example.pizza.service.ProductService;



@Controller
@RequestMapping("/shop")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	
	@Autowired
	private ICategoryService categoryService;
	
	
	@Autowired
	IShoppingCartService shoppingCartService;
	
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("soLuongMua", shoppingCartService.getCount());
		return listByPage(model, 1, null, null, null);
	}
	
	
	@GetMapping("/page/{pageNumber}")     //   page/1 => PathVariable("Tên trong view")---page=1 => request()
	public String listByPage(Model model, @PathVariable("pageNumber") int currentPage,
			@Param("sort") String sort,
			@Param("keyword") String keyword,
			@Param("idCategory") Integer idCategory
	) {
		
		//----------Danh mục ----------------------------------------------------------------//
		List<Category> listCategory = categoryService.findAll();
		//----------Kết thúc Danh mục -------------------------------------------------------//
		
		
		//------------ Sản Phẩm ------------------------------------------------------------ //
		Page<Product> page = productService.listAllSort(currentPage, sort, keyword, idCategory); 
		List<Product> ls = page.getContent(); //lấy sản phẩm của trang chọn
		
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		Locale lc = new Locale("vi", "VN");
	    NumberFormat nf = NumberFormat.getNumberInstance(lc);
	    //------------Kết thúc Sản Phẩm ---------------------------------------------------- //
	    
	    
	    /*------------Sản phẩm theo category---------------------------------------------------------//
	    List<Product> productsByIdCate = categoryService.findById(1).get().getProducts();
	   //-------------Kết thúc sản phẩm theo category------------------------------------------------*/
	    
	    model.addAttribute("nf", nf);
		model.addAttribute("products", ls);
		//model.addAttribute("productsByIdCate", productsByIdCate);
		model.addAttribute("categories", listCategory);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("sort", sort);
		model.addAttribute("keyword", keyword);
		model.addAttribute("idCategory", idCategory);
		return "products";
	}
	
	
	
	
	@RequestMapping("/product-detail/{id}")
	public String productDetail(Model model, @PathVariable("id") int id) {
		Locale lc = new Locale("vi", "VN");
	    NumberFormat nf = NumberFormat.getNumberInstance(lc);
	    
	    
	    
		Optional<Product> product = productService.findById(id);
		model.addAttribute("nf", nf);
		model.addAttribute("product",product.get());
		model.addAttribute("id",id);
		return "product-detail";
	}
	
	@RequestMapping("/test")
	public String test(Model model) {
		
	    
		List<Product> ls = categoryService.findById(1).get().getProducts();
		model.addAttribute("products",ls);
		return "test";
	}
	
	
	
}