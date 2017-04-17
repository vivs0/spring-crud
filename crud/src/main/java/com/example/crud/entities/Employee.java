package com.example.crud.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.apache.log4j.Logger;
import org.hibernate.FetchMode;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.example.crud.user.dao.UserTaskImpl;
import com.example.crud.validation.DateValidation;
import com.example.crud.validation.Phone;
import com.example.crud.validation.UniqueKey;

@Entity
@SelectBeforeUpdate(value=true)
@DynamicUpdate(value=true)
@DynamicInsert(value=true)
@Table(name="Employee")
@NamedQueries(
		{@NamedQuery(name="Employee.list",query="select e from Employee e"),
		@NamedQuery(name="Employee.findbyname",query="select e from Employee e join User u on e.ID=u.ID where e.firstName = :firstName")})

public class Employee implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="empid")
	private int ID;
	
	@Column(name="firstname")
//	@NotEmpty(message="Field cannot be left blank")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="email",unique=true)
/*	@NotEmpty(message="Email field cannot be left blank")
	@org.hibernate.validator.constraints.Email(regexp="^([a-zA-Z.]){4,30}\\w+@[-+.0-9A-Z_a-z]+\\.[A-Za-z]{2,4}$", message="invalid email")
	@Length(min=8,max=50)
	@UniqueKey(columnName="Email",className=Employee.class,message="Email already registered")*/
	private String Email;

	@Column(name="contact")
/*	@NotNull(message="Contact cannot be empty")
	@Phone(message="Invalid contact")
	@UniqueKey(columnName="Contact",className=Employee.class,message="contact already registered")
*/	private Long Contact;
		
	@Column(name="dateofbirth")
	@DateTimeFormat(iso = ISO.DATE,pattern="dd-MM-yyyy")
/*	@DateValidation(message = "invalid date",allowNull=false)*/
	private Date DateOfBirth;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="employee")
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Employee(){}

	public Employee(String firstName, String lastName, String gender, String email, Long contact,
			Date dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		Email = email;
		Contact = contact;
		DateOfBirth = dateOfBirth;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Long getContact() {
		return Contact;
	}

	public void setContact(Long contact) {
		Contact = contact;
	}

	public Date getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Employee [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", Email=" + Email + ", Contact=" + Contact + ", DateOfBirth=" + DateOfBirth + ", user=" + user + "]";
	}

	
}
