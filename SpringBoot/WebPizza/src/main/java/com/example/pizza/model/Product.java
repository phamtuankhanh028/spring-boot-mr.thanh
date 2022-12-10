package com.example.pizza.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jdk.jfr.DataAmount;

@Entity(name="sanpham")  // thêm name nếu xài hsql còn k thì xài native
@Table(name="sanpham")
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int maSP;
	
	
	@Column(name="TenSP", columnDefinition ="nvarchar(255) not null")
	private String tenSP;
	
	
	@ManyToOne
	@JoinColumn(name ="MaLoai")
	Category category;
	
	@Column(name="SoLuong")
	private Integer soLuong;
	
	@Column(name="DonViTinh", columnDefinition ="nvarchar(255) not null")
	private String donViTinh;
	
	@Column(name="HinhAnh", columnDefinition ="nvarchar(255) not null")
	private String hinhAnh;
	
	@Column(name="DonGia")
	private Integer donGia;

	
	@JsonIgnore
	@OneToMany(mappedBy="product")    
	private List<OrderDetail> orderDetails;
	
	
	public Product() {
		super();
	}



	public int getMaSP() {
		return maSP;
	}

	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public int getDonGia() {
		return donGia;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
		
	
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	
	
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
}