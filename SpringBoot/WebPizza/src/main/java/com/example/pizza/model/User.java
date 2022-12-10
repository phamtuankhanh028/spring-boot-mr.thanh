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



@Entity(name="khachhang")
@Table(name="khachhang")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer maKH;
	
	
	@Column(name = "TaiKhoan", columnDefinition ="nvarchar(255) not null")
	private String taiKhoan;
	
	@Column(name = "MatKhau", columnDefinition ="nvarchar(255) not null")
	private String matKhau;
	
	@Column(name = "HoTen", columnDefinition ="nvarchar(255) not null")
	private String hoTen;
	
	
	@Column(name = "DiaChi", columnDefinition ="nvarchar(255) not null")
	private String diaChi;
	
	
	@Column(name = "sdt", columnDefinition ="nvarchar(255) not null")
	private String sdt;


	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Order> orders;
	
	
	public User() {
		super();
	}


	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}


	public Integer getMaKH() {
		return maKH;
	}


	public void setMaKH(Integer maKH) {
		this.maKH = maKH;
	}


	public String getTaiKhoan() {
		return taiKhoan;
	}


	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}


	public String getMatKhau() {
		return matKhau;
	}


	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	

	public List<Order> getOrders() {
		return orders;
	}
	
}
