package com.example.pizza.service;

import java.util.Optional;

import com.example.pizza.model.Order;

public interface IOrderService {

	void deleteAll();

	void deleteAll(Iterable<? extends Order> entities);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Order entity);

	void deleteById(Integer id);

	long count();

	Iterable<Order> findAllById(Iterable<Integer> ids);

	Iterable<Order> findAll();

	boolean existsById(Integer id);

	Optional<Order> findById(Integer id);

	<S extends Order> Iterable<S> saveAll(Iterable<S> entities);

	Order save(Order entity);

}
