package com.example.pizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.pizza.model.Product;

public interface IProductService {

	void deleteAll();

	void deleteAll(List<Product> entities);

	void deleteAllById(List<Integer> ids);

	void delete(Product entity);

	void deleteById(Integer id);

	long count();
	Page<Product> listAllSort(int pageNumber, String sortText, String keyword, Integer idCategory);
	
	Page<Product> listAll(int pageNumber);

	List<Product> findAllById(List<Integer> ids);

	List<Product> findAll();

	boolean existsById(Integer id);

	Optional<Product> findById(Integer id);

	List<Product> saveAll(List<Product> entities);

	Page<Product> findAll(Pageable pageable);

	List<Product> findAll(Sort sort);

	Product save(Product entity);

	List<Product> findTopSeller(int top);

}
