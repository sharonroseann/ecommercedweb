package com.pro.config;

import java.sql.DriverManager;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.pro.model.Category;
import com.pro.model.Order;
import com.pro.model.Product;
import com.pro.model.Supplier;
import com.pro.model.User;
import com.pro.model.Cart;
@Configuration
@EnableTransactionManagement
@ComponentScan("com.pro.*")

public class DBConfig {
	@Bean(name="dataSource")
	
	//1.Create  a DataSource object
	public DataSource getH2DataSource() {
		DriverManagerDataSource  datasource=new DriverManagerDataSource();
		
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUsername("shar66");
		datasource.setPassword("shar66");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/project1");
		System.out.println("===Creating DataSource Bean==");
		return datasource;
		
	}
	
	//2. Create a SessionFactory object
	@Bean(name="SessionFactory")
	public SessionFactory getSessionFactory() {
	Properties hibernateproperties=new Properties();
		hibernateproperties.put("hibernate.hbm2ddl.auto","update");
		
		hibernateproperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		LocalSessionFactoryBuilder factory1=new LocalSessionFactoryBuilder(getH2DataSource());
		factory1.addProperties(hibernateproperties)	;
		
		factory1.addAnnotatedClass(Category.class);
		factory1.addAnnotatedClass(Supplier.class);
		factory1.addAnnotatedClass(Product.class);
		factory1.addAnnotatedClass(User.class);
		factory1.addAnnotatedClass(Cart.class);	
		factory1.addAnnotatedClass(Order.class);	
		SessionFactory sessionFactory=factory1.buildSessionFactory();
		System.out.println("===Creating the SessionFactory Bean====");
		return sessionFactory;
		
	}
	
	//3. Create a HibernateTransactionManager
	@Bean(name="txManager")
	
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("Creating the TransactionManager Bean");
		return new HibernateTransactionManager(sessionFactory);
		
	}

}