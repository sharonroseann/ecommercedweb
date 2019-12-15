package com.pro.model;

import java.sql.Date;



import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Order
{
	@Id
	@GeneratedValue
	int orderId;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUsername() {
		return userName;
	}
	public void setUsername(String username) {
		this.userName = username;
	}
	public java.util.Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(java.util.Date orderDate) {
		this.orderDate = orderDate;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getPmode() {
		return Pmode;
	}
	public void setPmode(String pmode) {
		Pmode = pmode;
	}
	String userName;
	java.util.Date orderDate;
	int totalAmount;
String Pmode;
}