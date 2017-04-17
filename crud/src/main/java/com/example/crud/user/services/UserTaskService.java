package com.example.crud.user.services;

import java.util.List;

import com.example.crud.entities.Employee;
import com.example.crud.entities.User;
import com.example.crud.form.ViewUpdateForm;

public interface UserTaskService {

	public List<Employee> getAllUser();
	public void Update(ViewUpdateForm form) ;
	public List<Employee> findByName(String name);
	public List<Employee> findById(String id);
	public List<Employee> findByEmail(String email);
	public List<Employee> findbyContact(String contact);
}
