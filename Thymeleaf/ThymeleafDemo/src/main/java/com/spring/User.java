package com.spring;

public class User {

	private String name;
	private String location;
	public User() {
		this.name = "";
		this.location = "";
	}
	public User(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", location=" + location + "]";
	}
	
}
