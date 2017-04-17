package com.example.crud.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy=DateConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RUNTIME)
public @interface DateValidation {
	
	String message() default "";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	boolean allowNull() default false;
}
