package com.pro.DAO;

import java.util.List;


import com.pro.model.User;

public interface UserDAO {
	

	public boolean registerUser(User user);
	public boolean deleteUser(User user);
	public boolean updateUser(User user);
	public User getUser(String username);
}