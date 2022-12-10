package com.example.pizza.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.pizza.model.Category;
import com.example.pizza.repository.CategoryRepository;

@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository; //tạo các hàm click phải chuột source->Generate Delegate Methods

	@Override
	public Category save(Category entity) {
		return categoryRepository.save(entity);
	}

	@Override
	public List<Category> saveAll(List<Category> entities) {
		return (List<Category>)categoryRepository.saveAll(entities);
	}

	@Override
	public Optional<Category> findById(Integer id) {
		return categoryRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return categoryRepository.existsById(id);
	}

	@Override
	public List<Category> findAll() {
		return (List<Category>)categoryRepository.findAll();
	}

	@Override
	public List<Category> findAllById(List<Integer> ids) {
		return (List<Category>)categoryRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return categoryRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public void delete(Category entity) {
		categoryRepository.delete(entity);
	}

	@Override
	public void deleteAllById(List<Integer> ids) {
		categoryRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Category> entities) {
		categoryRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		categoryRepository.deleteAll();
	}

	
	
	
	
	
	//chuot phai chọn Refactor->Pull Up bên interface sẽ có

}
