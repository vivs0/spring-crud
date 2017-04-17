package com.example.crud.other;

import java.beans.PropertyEditorSupport;

import org.apache.log4j.Logger;

import com.example.crud.HomeController;
import com.example.crud.entities.Gender;

public class GenderBinder extends PropertyEditorSupport{

	final private Logger logger = Logger.getLogger(GenderBinder.class);

	@Override
	public String getAsText() {
		logger.debug("get as text");
		return null;
	}

	@Override
	public Object getValue() {
		logger.debug("get value");
		return null;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		logger.debug("set as text");
	}

	@Override
	public void setValue(Object value) {
		logger.debug("set as value");
		
	}

}
