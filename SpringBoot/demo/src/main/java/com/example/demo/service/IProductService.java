package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface IProductService {

	// Liệt kê các phương thức sử dụng.
	
	public List<Product> getAllStudent();
	public Product addProduct(Product product);
	public Product updateProduct(int id, Product product);
	public Product getById(int id);
}
