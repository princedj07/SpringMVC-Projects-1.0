package org.spring.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.spring.app.custom.validator.EmailValidator;
import org.spring.app.custom.validator.UserNameValidator;
import org.spring.app.model.CommunicationDTO;
import org.spring.app.model.Phone;
import org.spring.app.model.UserRegistrationDTO;
import org.spring.app.utility.NamePropertyEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

	@RequestMapping("/register")
	public String showRegistrationpage(@ModelAttribute("userReg") UserRegistrationDTO userRegistrationDTO) {
		
		System.out.println("Register Page...");
//		userRegistrationDTO.setName("Prince");
//		UserRegistrationDTO registrationDTO = new UserRegistrationDTO();
//		model.addAttribute("userReg", registrationDTO);
		
//		load the saved user data from the data base
		Phone phone = new Phone();
		phone.setCountryCode("91");
		phone.setUserNumber("9309725333");
		
		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhone(phone);
		
		userRegistrationDTO.setCommunicationDTO(communicationDTO);
		
		return "user-registration-page";
	}
	
	@RequestMapping("/registration-success")
	public String processUserRegistration(
			@Valid @ModelAttribute("userReg") UserRegistrationDTO userRegistrationDTO,
			BindingResult bindingResult) {

		System.out.println("RegistrationController.processUserRegistration()");
		System.out.println("Name Value Entered by the User is : "+ "|" +userRegistrationDTO.getName()+ "|");
		
		if (bindingResult.hasErrors()) {
			System.out.println("RegistrationController.processUserRegistration() has some errors..");

			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError error : allErrors) {
				System.out.println(error);
			}
			return "user-registration-page";
		}

		return "register-success-page";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		System.out.println("RegistrationController.initBinder() method Executed >>>>>>>>>>");
//		webDataBinder.setDisallowedFields("name");
		
		// Property Editor
		StringTrimmerEditor stringTrimmerEditor = new  StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, "name", stringTrimmerEditor);
		
		NamePropertyEditor namePropertyEditor = new NamePropertyEditor();
		webDataBinder.registerCustomEditor(String.class, "name", namePropertyEditor);
		
		webDataBinder.addValidators(new UserNameValidator());
		webDataBinder.addValidators(new EmailValidator());
		
	}
	
	
	
}
