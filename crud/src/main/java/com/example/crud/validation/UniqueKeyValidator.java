package com.example.crud.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UniqueKeyValidator implements ConstraintValidator<UniqueKey, Object> {


	@PersistenceContext
	private EntityManager emf;
	
	private String columnNames;
	private Class<?> entityClass;
	
	public Session getSession(){
		Session session = null;
		try{
			session = emf.unwrap(Session.class);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return session;
	}
	@Override
	public void initialize(UniqueKey constraintAnnotation) {
		this.columnNames = constraintAnnotation.columnName();
		this.entityClass = constraintAnnotation.className();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Class<?> entityClass = this.entityClass;
		System.out.println("Class: "+entityClass.toString());
		
		Criteria criteria = getSession().createCriteria(entityClass);
		try{
			criteria.add(Restrictions.eq(this.columnNames, value));
		}catch(Exception e){
			e.printStackTrace();
		}
		return criteria.list().size()==0;
	}
}
