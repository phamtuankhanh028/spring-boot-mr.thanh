package com.example.pizza.service;

import java.util.List;
import java.util.Optional;

import com.example.pizza.model.User;

public interface IUserService {

	void deleteAll();

	

	void deleteAll(List<User> entities);

	void deleteAllById(List<Integer> ids);

	void delete(User entity);

	void deleteById(Integer id);

	long count();

	List<User> findAllById(List<Integer> ids);

	List<User> findAll();

	boolean existsById(Integer id);

	Optional<User> findById(Integer id);

	List<User> saveAll(List<User> entities);

	User save(User entity);



	Optional<User> findByUsername(String username);



	User login(String username, String password);

	

}
