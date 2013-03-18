package org.drewps.propertyeditor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomDateEditor extends PropertyEditorSupport {
	private static final SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try { setValue(format.parse(text)); } catch (ParseException e) { }
	}
	
	@Override
	public String getAsText() {
		return format.format(getValue());
	}
}