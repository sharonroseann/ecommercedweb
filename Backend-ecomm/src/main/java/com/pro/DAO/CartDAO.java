package com.pro.DAO;


import java.util.List;

import com.pro.model.Cart;

public interface CartDAO 
{
	public boolean addCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public boolean updateCart(Cart cart);
	public Cart getCart(int cardId);
	public List <Cart> listCart(String username);
	
}