package com.pro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cart 
{
	@Id
	@GeneratedValue
	int cartId;
	
	int productid;
	int quantity;
	int price;
	
	String productName;
	String userName;
	String paymentStatuse;
	
	public String getPaymentStatuse() {
		return paymentStatuse;
	}
	public void setPaymentStatuse(String paymentStatuse) {
		this.paymentStatuse = paymentStatuse;
	}
	public int getProductid() 
	{
		return productid;
	}
	public void setProductId(int productid) 
	{
		this.productid = productid;
	}
	
	public int getCartId() 
	{
		return cartId;
	}
	public void setCartId(int cartId) 
	{
		this.cartId = cartId;
	}
	public int getQuantity() 
	{
		return quantity;
	}
	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}
	public int getPrice() 
	{
		return price;
	}
	public void setPrice(int price) 
	{
		this.price = price;
	}
	public String getProductName() 
	{
		return productName;
	}
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}
	public String getUsername() 
	{
		return userName;
	}
	public void setUsername(String username) 
	{
		this.userName = username;
	}

}