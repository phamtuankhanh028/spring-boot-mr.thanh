package com.example.pizza.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.pizza.model.Product;
import com.example.pizza.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("SELECT kh FROM khachhang kh WHERE kh.taiKhoan=?1")
	public Optional<User> findByUsername(String username);
}
