package com.example.crud.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, ANNOTATION_TYPE })
@Constraint(validatedBy = UniqueKeyValidator.class)
public @interface UniqueKey {
	String columnName();
	Class<?> className();
	String message() default "error in field";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
