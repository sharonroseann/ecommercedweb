package com.pro.DAO;


import java.util.List;


import com.pro.model.Product;
public interface ProductDAO 
{
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public Product getProduct(int productId);
	public List<Product> listProducts();
}
