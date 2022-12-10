package com.example.pizza.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizza.model.Order;
import com.example.pizza.repository.OrderRepository;


@Service
public class OrderService implements IOrderService{

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order save(Order entity) {
		return orderRepository.save(entity);
	}

	@Override
	public <S extends Order> Iterable<S> saveAll(Iterable<S> entities) {
		return orderRepository.saveAll(entities);
	}

	@Override
	public Optional<Order> findById(Integer id) {
		return orderRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return orderRepository.existsById(id);
	}

	@Override
	public Iterable<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Iterable<Order> findAllById(Iterable<Integer> ids) {
		return orderRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return orderRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		orderRepository.deleteById(id);
	}

	@Override
	public void delete(Order entity) {
		orderRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		orderRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends Order> entities) {
		orderRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		orderRepository.deleteAll();
	}
	
	
	
}
