package com.pro.DAO;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pro.model.Product;
import com.pro.model.User;

@Repository("userDAO")
@Transactional

public class UserDAOImpl  implements  UserDAO
{
  @Autowired
  SessionFactory sessionFactory;
	public boolean registerUser(User user) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(user);
		
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteUser(User user) 
	{
		try 
		{
			sessionFactory.getCurrentSession().delete(user); 
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	
	}

	public boolean updateUser(User user)
	{
		try 
		{
			sessionFactory.getCurrentSession().update(user); 
				
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


	

	public List<User> listUser() {
		
		Session session=sessionFactory.openSession();
		List<User> listUserDetails=(List<User>)session.createQuery("from User").list();
		session.close();
		return  listUser();
	}

	
	public User getUser(String username) 
	
	{
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,username);
		session.close();
		return user;
	}



}