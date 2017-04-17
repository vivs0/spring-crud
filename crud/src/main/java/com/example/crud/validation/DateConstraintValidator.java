package com.example.crud.validation;

import java.sql.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.log4j.Logger;

public class DateConstraintValidator implements ConstraintValidator<DateValidation, Date>{
	
	private boolean allowNull;
	@Override
	public void initialize(DateValidation date) {
		// TODO Auto-generated method stub
		allowNull = date.allowNull();
	}

	@Override
	public boolean isValid(Date date, ConstraintValidatorContext arg1) {
		if(!allowNull && date==null)
		{
			return false;
		}
		return true;
	}

}
