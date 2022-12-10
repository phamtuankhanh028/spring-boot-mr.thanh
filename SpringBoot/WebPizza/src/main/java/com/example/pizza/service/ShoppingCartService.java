package com.example.pizza.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.example.pizza.model.CartItem;

@SessionScope
@Service
public class ShoppingCartService implements IShoppingCartService{

	Map<Integer, CartItem> maps = new HashMap<>(); //gio hàng 
	
	@Override
	public void add(CartItem item) {
		CartItem cartItem = maps.get(item.getMaSP());   //gọi item trong maps(giỏ hàng) theo key(MASP) gán vào cartItem
		if(cartItem == null) {
			maps.put(item.getMaSP(), item);
		}else {
			
			cartItem.setSoLuongMua(cartItem.getSoLuongMua()+1);
		}
	}
	
	@Override
	public void addByDetail(CartItem item, int slm) {
		CartItem cartItem = maps.get(item.getMaSP());
		if(cartItem == null) {
			maps.put(item.getMaSP(), item);
		}else {
			cartItem.setSoLuongMua(cartItem.getSoLuongMua()+slm);
		}
		
	}
	
	@Override
	public void remove(int maSP) {
		maps.remove(maSP);
	}
	
	
	@Override
	public CartItem update(int maSP, int soLuong) {
		CartItem cartItem = maps.get(maSP);
		cartItem.setSoLuongMua(soLuong);
		return cartItem;
	}
	
	
	@Override
	public void clear() {
		maps.clear();
	}
	
	
	@Override
	public Collection<CartItem> getAllItems(){
		return maps.values();
	}
	
	
	@Override
	public int getCount() {
		return maps.values().size();
	}
	
	
	@Override
	public int getAmount() {
		return maps.values().stream().mapToInt(item -> item.getSoLuongMua() * item.getDonGia()).sum();  //item là CartItem
	}
	
	
}
