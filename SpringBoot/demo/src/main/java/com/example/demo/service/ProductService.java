package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService implements IProductService{

	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> getAllStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product addProduct(Product product) {
		productRepository.save(product);
		return null;
	}

	@Override
	public Product updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
