package com.pro.controller;

import java.util.Collection;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.UserDAO;
import com.ecomm.model.UserDetail;



@Controller
public class UserController {
	
	  @Autowired
	    UserDAO userDao;
	
	@RequestMapping("/login_success")
	public String checkLogin(HttpSession session, Model m) 
	{
		String page="";
		boolean loggedIn;
		
		SecurityContext sContext=SecurityContextHolder.getContext();

		Authentication authentication =sContext.getAuthentication();

		
		String username=authentication.getName();
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			session.setAttribute("role", role.getAuthority());
			
			if(role.getAuthority().equals("user"))
			
			{
				loggedIn=true;
				page="UserHome";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username", username);
				
			}
			else
		
			{
				loggedIn=true;
				page="adminhome";
				session.setAttribute("loggedIn",loggedIn);
				session.setAttribute("username", username);
			}
		}
		
		

		
		return page;
		
	}
	
	@RequestMapping("/loginerror")
	public String loginError(Model model)
	{
		model.addAttribute("error", "Invalid username and password");
		return "login";
		
	}

	
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
    public String addUser(Model m, @RequestParam("mobileNo")String mobileNo,@RequestParam("userName")String username,@RequestParam("password")String password,@RequestParam("customerName")String customerName,@RequestParam("customerAddr")String customerAddr)
    {
    	    	
    	UserDetail user=new UserDetail();
    	user.setAddr(customerAddr);
    	user.setCustomerName(customerName);
    	user.setEnabled(true);
    	user.setMobileNo(mobileNo);
    	user.setPassword(password);
       	user.setRole("user");
    	
    	user.setUserName(username);
    	
 
    

    	
    	
    	
    	userDao.registerUser(user);
		return "login";
    	
	}
	
}