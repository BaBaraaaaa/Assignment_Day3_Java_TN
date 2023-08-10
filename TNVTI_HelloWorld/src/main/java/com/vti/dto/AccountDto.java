package com.vti.dto;


import java.util.Date;

import com.vti.com.vti.entity.Department;
import com.vti.com.vti.entity.Position;


public class AccountDto  {
	private int id;
	private String email;
	private String username;
	private String fullName;
	private Department department;
	private Position position;
	private Date createDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public AccountDto(int id, String email, String username, String fullName, Department department,
			Position position, Date createDate) {
		
		this.id = id;
		this.email = email;
		this.username = username;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}
public AccountDto() {
	// TODO Auto-generated constructor stub
}
}
