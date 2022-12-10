package com.example.pizza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.pizza.model.Order;
import com.example.pizza.model.OrderDetail;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer>{

}
