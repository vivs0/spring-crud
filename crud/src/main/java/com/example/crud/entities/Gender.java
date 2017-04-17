package com.example.crud.entities;

public enum Gender {
	MALE(1,"Male"),
	FEMALE(2,"Female");
	
	private int value;
	private String name;
	
	private Gender(int value, String name)
	{
		this.setValue(value);
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
