package org.spring.app.custom.validator;

import org.spring.app.model.UserRegistrationDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserNameValidator implements Validator {

	// Need to write checks if UsernameValidator supports a given Object
	
	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationDTO.class.equals(clazz);
	}

	//Need to write our Custom Validation Logic
	
	@Override
	public void validate(Object object, Errors errors) {
		
		// To check if the field is null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "UserName Can't Be Empty");
		
		//the String should contain a _
		String userName = ((UserRegistrationDTO)object).getUserName();
		
		if (!userName.contains("_")) {
			errors.rejectValue("userName", "userName.invalidString", "Given String must Contains a '_'");
		}
	}

}
