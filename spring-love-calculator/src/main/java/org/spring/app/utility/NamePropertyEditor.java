package org.spring.app.utility;

import java.beans.PropertyEditorSupport;

public class NamePropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		System.out.println("NamePropertyEditor.setAsText() method executed >>>>>");
		String myConvertedString = text.toUpperCase();
		setValue(myConvertedString);

	}

}
