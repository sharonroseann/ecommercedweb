package com.pro.DAO;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory; 
	
	public boolean addSupplier(Supplier supplier) 
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}


	public boolean deleteSupplier(Supplier supplier ) 
	{
		try
		{
		sessionFactory.getCurrentSession().delete(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	
	public boolean updateSupplier(Supplier supplier) 
	{
		try
		{
		sessionFactory.getCurrentSession().update(supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public Supplier getSupplier(int supplierId) 
	{
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierId);
		session.close();
		return supplier;
	}

	public List<Supplier> listSuppliers() 
	{
		Session session=sessionFactory.openSession();
		List<Supplier> listSuppliers=(List<Supplier>)session.createQuery("from Supplier").list();
		session.close();
		return listSuppliers;
	}


	
}