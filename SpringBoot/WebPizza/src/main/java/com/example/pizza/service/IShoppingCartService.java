package com.example.pizza.service;

import java.util.Collection;

import com.example.pizza.model.CartItem;

public interface IShoppingCartService {

	int getAmount();

	int getCount();

	Collection<CartItem> getAllItems();

	void clear();

	CartItem update(int maSP, int soLuong);

	void remove(int maSP);

	void add(CartItem item);
	
	void addByDetail(CartItem item, int slm);

	// định nghĩa các hàm
	
}
