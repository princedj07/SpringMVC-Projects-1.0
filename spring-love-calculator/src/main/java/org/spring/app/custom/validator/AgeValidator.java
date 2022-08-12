package org.spring.app.custom.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private int lower;	//30
	private int upper;	//75
	
	@Override
	public void initialize(Age age) {

		System.out.println("AgeValidator.initialize() method executed....with age---: "+age.lower() + "---" +age.upper());
		
		this.lower = age.lower();
		this.upper = age.upper();
		
	}
	
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {

		System.out.println("AgeValidator.isValid() method executed....And Age is----: " + age);

		if (age == null) {
			System.out.println("Age is Null");
			return false;
		}
		if (age < lower || age > upper) {
			System.out.println("Age is out of scope");
			return false;
		}

		return true;
	}

}
