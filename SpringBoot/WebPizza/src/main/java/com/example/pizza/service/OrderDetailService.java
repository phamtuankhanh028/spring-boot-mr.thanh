package com.example.pizza.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizza.model.OrderDetail;
import com.example.pizza.repository.OrderDetailRepository;

@Service
public class OrderDetailService implements IOrderDetailService{

	
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Override
	public OrderDetail save(OrderDetail entity) {
		return orderDetailRepository.save(entity);
	}

	@Override
	public <S extends OrderDetail> Iterable<S> saveAll(Iterable<S> entities) {
		return orderDetailRepository.saveAll(entities);
	}

	@Override
	public Optional<OrderDetail> findById(Integer id) {
		return orderDetailRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return orderDetailRepository.existsById(id);
	}

	@Override
	public Iterable<OrderDetail> findAll() {
		return orderDetailRepository.findAll();
	}

	@Override
	public Iterable<OrderDetail> findAllById(Iterable<Integer> ids) {
		return orderDetailRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return orderDetailRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		orderDetailRepository.deleteById(id);
	}

	@Override
	public void delete(OrderDetail entity) {
		orderDetailRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		orderDetailRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends OrderDetail> entities) {
		orderDetailRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		orderDetailRepository.deleteAll();
	}
	
	
	
}
