package org.spring.app.custom.validator;

import org.spring.app.model.UserRegistrationDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.empty");
		
		// Should have Email Field ending with gmail.com
		
		String email = ((UserRegistrationDTO)target).getCommunicationDTO().getEmail();
		
		if(!email.endsWith("gmail.com")) {
			errors.rejectValue("communicationDTO.email", "email.invalidDomain");
		}
		
	}

}
