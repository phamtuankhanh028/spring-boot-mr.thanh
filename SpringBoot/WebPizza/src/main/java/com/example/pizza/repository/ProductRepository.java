package com.example.pizza.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.pizza.model.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{
		
	
		//@Query(value ="SELECT * FROM sanpham WHERE tenSP LIKE %?1%", nativeQuery=true)
		@Query("SELECT sp FROM sanpham sp WHERE sp.tenSP LIKE %?1%")
		public Page<Product> findAll(String keywork, Pageable pageable);
		
		
		@Query(value ="SELECT * FROM sanpham WHERE Ma_Loai=?", nativeQuery=true)
		public Page<Product> findAll(Integer id, Pageable pageable);
		
		
		@Query(value = "select sp.*,sum(ct.So_luong) as tsl from sanpham sp inner join cthoadon ct on ct.masp = sp.masp group by 1 order by tsl desc limit 0,?;", nativeQuery=true)
		public List<Product> findTopSeller(int top);
	
}
