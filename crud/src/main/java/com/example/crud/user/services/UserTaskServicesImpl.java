package com.example.crud.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crud.entities.Employee;
import com.example.crud.entities.User;
import com.example.crud.form.ViewUpdateForm;
import com.example.crud.user.dao.UserTask;

@Service
@Transactional
public class UserTaskServicesImpl implements UserTaskService {

	@Autowired
	private UserTask userTask;
	
	@Override
	public List<Employee> getAllUser() {
		return userTask.getAllUser();
	}

	@Override
	public void Update(ViewUpdateForm form) {
		userTask.Update(form);
	}

	@Override
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		return userTask.findByName(name);
	}

	@Override
	public List<Employee> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findbyContact(String contact) {
		// TODO Auto-generated method stub
		return null;
	}

}
