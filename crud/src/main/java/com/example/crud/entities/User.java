package com.example.crud.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="users")
//@NamedQuery(name="User.list",query="select u from Users u")
public class User implements Serializable{
	
	@Id
	@Column(name="empid")
	@GeneratedValue(generator="fkey")
	@GenericGenerator(strategy="foreign",name="fkey",parameters=@Parameter(name = "property", value="employee"))
	private int ID;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String Password;
	
	@OneToOne
	@JoinColumn(name="statusid", foreignKey=@ForeignKey(name="fk_user_status"),referencedColumnName="id")
	private Status statusId;

	@OneToOne(optional=true)
	@PrimaryKeyJoinColumn
	private Employee employee;
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public User() {
	}

	public User(String username, String password, Status statusId) {
		super();
		this.username = username;
		Password = password;
		this.statusId = statusId;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Status getStatusId() {
		return statusId;
	}

	public void setStatusId(Status statusId) {
		this.statusId = statusId;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", username=" + username + ", Password=" + Password + ", statusId=" + statusId + "]";
	}
	
	
}
