package com.example.pizza.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@Table(name="loai")
public class Category implements Serializable{

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int maLoai;
	
	
	@Column(name="TenLoai", length = 255, columnDefinition ="nvarchar(100) not null")
	private String ten;
	
	@Column(name="HinhAnh", columnDefinition ="nvarchar(255) not null")
	private String hinhAnh;
	
	@JsonIgnore
	@OneToMany(mappedBy="category")    ///Class Category và Class Product sẽ liên kết với nhau thông qua tên “category”.
	private List<Product> products;
	
	
	

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	
}
