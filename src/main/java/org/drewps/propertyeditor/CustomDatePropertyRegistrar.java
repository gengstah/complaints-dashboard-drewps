package org.drewps.propertyeditor;

import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomDatePropertyRegistrar implements PropertyEditorRegistrar {
	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		PropertyEditor propertyEditor = new CustomDateEditor(new SimpleDateFormat("MM/dd/yyyy"), true);
		registry.registerCustomEditor(Date.class, propertyEditor);
	}
}