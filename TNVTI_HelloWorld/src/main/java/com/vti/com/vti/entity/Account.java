package com.vti.com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Account")
public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "Email", length = 50, nullable = false )
	private String email;
	
	@Column(name = "Username", length = 50, nullable = false)
	private String username;
	@Column(name = "FullName", length = 50, nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "Department_ID", referencedColumnName = "DepartmentID", nullable = false)
	private Department department;
	@ManyToOne
	@JoinColumn(name = "Position_ID", referencedColumnName = "PositionID", nullable = false)
	private Position position;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateDate", nullable = false, columnDefinition = "datetime default current_timestamp")
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

	public String getName() {
		return name;
	}

	public void setName(String fullName) {
		this.name = fullName;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Department getDepartment() {
		return department;
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

	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(String email, String username, String name, Department department, Position position,
			Date createDate) {
		this.email = email;
		this.username = username;
		this.name = name;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}

}
