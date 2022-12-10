package com.example.pizza.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.pizza.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer>{

}
