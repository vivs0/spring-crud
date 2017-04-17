package com.example.crud.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class  PhoneConstraintValidator implements ConstraintValidator<Phone, Long> {

	@Override
	public void initialize(Phone phone) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext ctx) {
		if(value==null)
		{
			return false;
		}
		else if(value.toString().length()!=10)
		{
			return false;
		}
			
		return true;
	}

}
