package com.pro.test;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pro.DAO.CartDAO;
import com.pro.model.Cart;
import com.pro.DAO.CartDAOImpl;


public class CartDAOUnitTest 
{
	static CartDAO cartDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}

	
	@Test
	
	public void addCartTest()
	{
		Cart cart=new Cart();
		cart.setProductName("Redmi");
		cart.setCartId(185);
		cart.setPrice(15650);
		cart.setProductId(7003);
		cart.setQuantity(6);
		cart.setUsername("Ram");
		assertTrue("Problem in adding the Cart ",cartDAO.addCart(cart));	
		}
	
	@Ignore
	@Test
	public void getCartTest()
	{
		assertNotNull("Problem in get Cart",cartDAO.getCart(1));
	}
	
	@Ignore 
	@Test
	public void deleteCartTest()
	{
		Cart cart=cartDAO.getCart(2);
		assertTrue("Problem in Deletion:",cartDAO.deleteCart(cart));
	}
	@Ignore
	@Test
	public void updateCartTest()
	{
		Cart cart=cartDAO.getCart(1);
		cart.setCartId(8);
		assertTrue("Problem in Updation",cartDAO.updateCart(cart));
	}

	@Ignore
	@Test
	public void listCartTest()
	{
		List<Cart> listCart=cartDAO.listCart("Ram");
		assertNotNull("No Cart",listCart);
		
		for(Cart cart:listCart)
		{
			System.out.print(cart.getCartId()+":::");
			System.out.print(cart.getProductid()+":::");
			System.out.println(cart.getPaymentStatuse()+":::");
			System.out.println(cart.getPrice()+":::");
			System.out.println(cart.getProductName()+":::");
			System.out.println(cart.getQuantity()+":::");
			System.out.println(cart.getUsername()+":::");
		}
	}
	
}