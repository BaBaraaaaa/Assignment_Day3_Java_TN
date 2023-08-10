package com.vti.form;

import java.util.Date;

import com.vti.com.vti.entity.Department;
import com.vti.com.vti.entity.Position;


public class AccountFormForCreating {

	private String email;
	private String username;
	private String Name;
	private Department department;
	private Position position;
	private Date createDate;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return Name;
	}
	public void setName(String fullName) {
		this.Name = fullName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public AccountFormForCreating() {
		// TODO Auto-generated constructor stub
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	
	
}
