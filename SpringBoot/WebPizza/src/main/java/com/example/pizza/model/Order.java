package com.example.pizza.model;

import java.io.Serializable;
import java.sql.Date;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="hoadon")
@Table(name="hoadon")
public class Order implements Serializable{

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int maHD;
	
	@ManyToOne
	@JoinColumn(name ="MaKH")
	User user;
	
	
	@Column(name="NgayLap")
	private Date ngayLap;
	
	@Column(name="TongTien")
	private int tongTien;

	@JsonIgnore
	@OneToMany(mappedBy="order")    
	private List<OrderDetail> orderDetails;
	
	public Order() {
		super();
	}

	public int getMaHD() {
		return maHD;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	
	
	
	
}
