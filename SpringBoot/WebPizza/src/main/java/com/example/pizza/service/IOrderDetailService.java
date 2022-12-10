package com.example.pizza.service;

import java.util.Optional;

import com.example.pizza.model.OrderDetail;

public interface IOrderDetailService {

	void deleteAll();

	void deleteAll(Iterable<? extends OrderDetail> entities);

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(OrderDetail entity);

	void deleteById(Integer id);

	long count();

	Iterable<OrderDetail> findAllById(Iterable<Integer> ids);

	Iterable<OrderDetail> findAll();

	boolean existsById(Integer id);

	Optional<OrderDetail> findById(Integer id);

	<S extends OrderDetail> Iterable<S> saveAll(Iterable<S> entities);

	OrderDetail save(OrderDetail entity);

}
