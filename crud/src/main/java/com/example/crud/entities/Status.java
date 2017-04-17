package com.example.crud.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status")
public class Status {

	@Id
	@Column(name="id")	
	private int statusid;
	
	@Column(name="statusname")
	private String statusName;

	
	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Status(int statusid) {
		super();
		this.statusid = statusid;
	}

	public int getStatusid() {
		return statusid;
	}

	public void setStatusid(int statusid) {
		this.statusid = statusid;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "Status [statusid=" + statusid + ", statusName=" + statusName + "]";
	}
	
	
}
	
