package com.vti.dto;

public class PositionDto {
	private int id;
	private String name;

	public PositionDto() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PositionDto(int id, String name) {
		
		this.id = id;
		this.name = name;
	}
}
