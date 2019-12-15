package com.pro.DAO;


import com.pro.model.Order;

import java.util.List;
public interface OrderDAO
{
	public boolean saveOrder(Order order);
	public boolean updateCart(String username, int orderId);
}