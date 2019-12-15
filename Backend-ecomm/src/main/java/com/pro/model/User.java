package com.pro.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table

public class User
{
	@Id
	@GeneratedValue
	
String username;
String password;
String role;
boolean enabled;
String customerName;
String addr;
String mobileNo;


public String getMobileNo() {
	return mobileNo;
}
public void setMobileNo(String mobileNo) {
	this.mobileNo = mobileNo;
}

public String getUserName() {
	return username;
}
public void setUserName(String userName) {
	this.username = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
public String getAddr() {
	return addr;
}
public void setAddr(String addr) {
	this.addr = addr;
}

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

}
