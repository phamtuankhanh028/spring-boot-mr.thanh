package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sanpham")
public class Product {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int maSP;
	
	
	@Column(name="TenSP")
	private String tenSP;
	
	@Column(name="MaLoai")
	private String maLoai;
	
	@Column(name="SoLuong")
	private int soLuong;
	
	@Column(name="DonViTinh")
	private String donViTinh;
	
	@Column(name="HinhAnh")
	private String hinhAnh;
	
	@Column(name="DonGia")
	private int donGia;

	
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

	public String getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
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
	
	
	
	
}
