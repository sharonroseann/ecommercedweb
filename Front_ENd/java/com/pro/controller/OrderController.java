package com.pro.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.DAO.CartDAO;
import com.pro.DAO.OrderDAO;
import com.pro.model.Cart;
import com.pro.model.Order;

@Controller

public class OrderController {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDAO orderDAO;
	
	@RequestMapping(value="/cart")
	public String ShowCart(Model m, HttpSession session)
	{
		
		
		String username=(String)session.getAttribute("username");
		List<Cart>listCart=cartDAO.listCart(username);
		m.addAttribute("listCart",listCart);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));
		
		return "Cart";
	}
	
	
	
	@RequestMapping("/Payment")
	public String showPaymentPage(Model m, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<Cart>listCart=cartDAO.listCart(username);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));
		
		return "Payment";
	}
	

	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String showReceipt(@RequestParam("pmode")String pmode,Model m, HttpSession session )
	{
		String username=(String)session.getAttribute("username");
		List<Cart>listCart=cartDAO.listCart(username);
		
		Order order=new Order();
		order.setUsername(username);
		order.setOrderDate(new java.util.Date());
		order.getOrderId();
		order.setPmode(pmode);
		order.setTotalAmount(this.calGrandTotalPrice(listCart));
		orderDAO.saveOrder(order);
		int orderId =order.getOrderId();
		System.out.println(orderId);
		orderDAO.updateCart(username, order.getOrderId());
		m.addAttribute("orderData",orderId);
	   // m.session.setAttribute("order", orderId);
		m.addAttribute("listCart", listCart);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));
		
		return "Receipt";
	}
	
	public int calGrandTotalPrice(List<Cart> listCart)
	{
		int grandTotal=0;
		int count=0;
		while(count<listCart.size())
		{
			Cart cart=listCart.get(count);
			grandTotal=grandTotal+(cart.getQuantity()*cart.getPrice());
			count=count+1;
			
		}
		return grandTotal;
	}

}