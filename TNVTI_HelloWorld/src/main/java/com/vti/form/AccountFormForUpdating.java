package com.vti.form;

import com.vti.com.vti.entity.Department;
import com.vti.com.vti.entity.Position;

public class AccountFormForUpdating {
	private String email;
	private String Name;
	private Department department;
	private Position position;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
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
	public AccountFormForUpdating() {
		// TODO Auto-generated constructor stub
	}
}
