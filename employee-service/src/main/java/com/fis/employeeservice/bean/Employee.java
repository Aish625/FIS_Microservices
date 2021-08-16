package com.fis.employeeservice.bean;


public class Employee{
	private int id;
	private String username;
	//private String password;
	public Employee() {
		
	}
	public Employee(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}
	
}
