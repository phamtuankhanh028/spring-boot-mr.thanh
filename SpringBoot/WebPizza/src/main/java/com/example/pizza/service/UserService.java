package com.example.pizza.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.pizza.model.User;
import com.example.pizza.repository.UserRepository;


@Service
public class UserService implements IUserService{

	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User save(User entity) {
		entity.setMatKhau(bCryptPasswordEncoder.encode(entity.getMatKhau()));
		return userRepository.save(entity);
	}

	
	@Override
	public User login(String username, String password) {
		Optional<User> user  = findByUsername(username);
		if(user.isPresent() && bCryptPasswordEncoder.matches(password, user.get().getMatKhau())) {
			return user.get();
		}
		
		return null;
	}
	
	
	@Override
	public Optional<User> findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	
	@Override
	public List<User> saveAll(List<User> entities) {
		return (List<User>)userRepository.saveAll(entities);
	}

	@Override
	public Optional<User> findById(Integer id) {
		return userRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return userRepository.existsById(id);
	}

	@Override
	public List<User> findAll() {
		return (List<User>)userRepository.findAll();
	}

	@Override
	public List<User> findAllById(List<Integer> ids) {
		return (List<User>)userRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return userRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

	@Override
	public void delete(User entity) {
		userRepository.delete(entity);
	}

	@Override
	public void deleteAllById(List<Integer> ids) {
		userRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<User> entities) {
		userRepository.deleteAll(entities);
	}

	

	@Override
	public void deleteAll() {
		userRepository.deleteAll();
	}

}
