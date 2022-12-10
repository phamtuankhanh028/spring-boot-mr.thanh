package com.example.pizza.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="cthoadon")
@Table(name="cthoadon")
public class OrderDetail implements Serializable{


	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int maCTHD;

    @OneToOne
    @JoinColumn(name = "maHD")
    private Order order;
	
	@ManyToOne
	@JoinColumn(name ="MaSP")
	Product product;
	
	@Column(name="SoLuong")
	private int soLuong;
	
	@Column(name="DonGia")
	private int donGia;
	
	@Column(name="ThanhTien")
	private int thanhTien;

	
	public OrderDetail() {
		super();
	}


	public int getMaCTHD() {
		return maCTHD;
	}


	public void setMaCTHD(int maCTHD) {
		this.maCTHD = maCTHD;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getSoLuong() {
		return soLuong;
	}


	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}


	public int getDonGia() {
		return donGia;
	}


	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}


	public int getThanhTien() {
		return thanhTien;
	}


	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

	

}
