package org.spring.app.utility;

import java.text.ParseException;
import java.util.Locale;

import org.spring.app.model.Phone;
import org.springframework.format.Formatter;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale locale) {
		
		System.out.println("PhoneNumberFormatter.print() method executed....");
		
		return phone.getCountryCode() + "-" + phone.getUserNumber();
		
	}

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {

		System.out.println("PhoneNumberFormatter.parse() method executed.....");

		// Split the String received from the user
		String[] phoneNumberArray = completePhoneNumber.split("-");
		Phone phone = new Phone();

		int index = completePhoneNumber.indexOf('-');
		System.out.println("Index---: " + index);

		if (index == -1) {
			System.out.println("Default CountryCode Set-1");
			phone.setCountryCode("91");
			phone.setUserNumber(phoneNumberArray[0]);
		} else if (index == 0) {
			System.out.println("Default CountryCode Set-2");
			phone.setCountryCode("91");
			phone.setUserNumber(phoneNumberArray[1]);
		} else {
			System.out.println("Dynamic CountryCode Set");
			phone.setCountryCode(phoneNumberArray[0]);
			phone.setUserNumber(phoneNumberArray[1]);
		}
		return phone;
	}

}
