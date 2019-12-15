package com.pro.controller;


import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pro.DAO.CategoryDAO;
import com.pro.DAO.ProductDAO;
import com.pro.model.Category;
import com.pro.model.Product;

@Controller
public class UserController 
{
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/login_success")
	public String loginSuccess(HttpSession session,Model m)
	{
		String page="";

		//This boolean variable will let us know whether the user is logged in
		boolean loggedIn=false;
		
		//This object will contain the logged in user detail like username and role.
		SecurityContext sContext=SecurityContextHolder.getContext();
		Authentication authentication=sContext.getAuthentication();
		
		String username=authentication.getName();
		
		//Getting all the roles associated with the user
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
				
		for(GrantedAuthority role:roles)
		{
					String role_name=role.getAuthority();
					session.setAttribute("role",role_name);
					if(role_name.equals("ROLE_ADMIN"))
					{
						loggedIn=true;
						session.setAttribute("loggedIn", loggedIn);
						session.setAttribute("username", username);
						page="AdminHome";
					}
					else
					{
						loggedIn=true;
						session.setAttribute("loggedIn", loggedIn);
						session.setAttribute("username", username);
						List<Product> productList=productDAO.productList();
						m.addAttribute("productList", productList);
								
						List<Category> categoryList=categoryDAO.listCategories();
						m.addAttribute("categoryList",categoryList);
						page="ProductHome";
					}
		}
		
		return page;
	}
	
	@RequestMapping(value="/perform_logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "Login";
	}
}














