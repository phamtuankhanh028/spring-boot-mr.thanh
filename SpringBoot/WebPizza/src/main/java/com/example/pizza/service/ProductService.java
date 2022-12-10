package com.example.pizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pizza.model.Product;
import com.example.pizza.repository.ProductRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
	private ProductRepository productRepository;

	
	@Override
	public Page<Product> listAllSort(int pageNumber, String sortText, String keyword, Integer idCategory) {
		Pageable pageable;
		if(sortText !=null) {
			Sort sort = Sort.by("donGia");
			sort = sortText.equals("asc")?sort.ascending():sort.descending();
			pageable= PageRequest.of(pageNumber -1, 5,sort); //lấy trang đầu với 10 sp
		}else {
			pageable = PageRequest.of(pageNumber -1, 5);
		}
		
		
		if(idCategory != null && keyword == null) {
			return productRepository.findAll(idCategory, pageable);
		}else {
			if(keyword != null) {
				return productRepository.findAll(keyword, pageable);
			}else {
				return productRepository.findAll(pageable);
			}
		}	
		
	}
		
	
	
	@Override
	public List<Product> findTopSeller(int top) {
		return productRepository.findTopSeller(top);
	}


	@Override
	public Page<Product> listAll(int pageNumber) {
		
		Pageable pageable = PageRequest.of(pageNumber -1, 5); //lấy trang đầu với 10 sp
		return productRepository.findAll(pageable);
	}
	
	@Override
	public Product save(Product entity) {
		return productRepository.save(entity);
	}

	
	@Override
	public List<Product> findAll(Sort sort) {
		return (List<Product>)productRepository.findAll(sort);
	}

	@Override
	public Page<Product> findAll(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	@Override
	public List<Product> saveAll(List<Product> entities) {
		return (List<Product>)productRepository.saveAll(entities);
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return productRepository.existsById(id);
	}

	@Override
	public List<Product> findAll() {
		return (List<Product>)productRepository.findAll();
	}
	

	@Override
	public List<Product> findAllById(List<Integer> ids) {
		return (List<Product>)productRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return productRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}

	@Override
	public void delete(Product entity) {
		productRepository.delete(entity);
	}

	@Override
	public void deleteAllById(List<Integer> ids) {
		productRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Product> entities) {
		productRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
	}
	
	
}
