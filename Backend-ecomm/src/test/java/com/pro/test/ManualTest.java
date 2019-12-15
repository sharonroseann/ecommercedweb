package com.pro.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.pro.DAO.CategoryDAO;
import com.pro.DAO.ProductDAO;
import com.pro.DAO.UserDAO;
import com.pro.model.Category;
import com.pro.model.Product;
import com.pro.model.User;

public class ManualTest 
{
	public static void main(String arg[])
	{
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		
		Category category=new Category();
		category.setCategoryName("SamsungMobile");
		category.setCategoryDesc("All Variety of Samsung Mobile");
		
		categoryDAO.addCategory(category);
		
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		Product product = new Product();
		product.setProductName("Samsung J7");
		product.setProductDesc(" mobile with 4G and 13MP Back camera");
		product.setPrice(12000);
		product.setStock(50);
		product.setCategoryId(2);
		product.setSupplierId(1);
		productDAO.addProduct(product);

		
	}
}