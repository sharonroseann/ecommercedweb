package com.pro.DAO;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean saveOrder(Order order) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(order);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateCart(String username) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("update Cart set Status='P',OrderId=:orderId where username=:username and status ='NP'");
		query.setParameter("username", username);
		int row_eff=query.executeUpdate();
		if(row_eff>0)
			return true;
		else
			return false;
		
	}

	public boolean saveOrder1(Order order) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateCart(String username, int orderId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean saveOrder(com.pro.model.Order order) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}