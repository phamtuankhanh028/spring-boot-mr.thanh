package com.example.pizza.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.pizza.model.Category;
import com.example.pizza.model.Product;

public interface CategoryRepository extends CrudRepository<Category, Integer>{

	
}
