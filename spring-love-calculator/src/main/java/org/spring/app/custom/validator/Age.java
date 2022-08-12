package org.spring.app.custom.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = AgeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Age {

//	String message() default "Age Should be between {lower} - {upper}";
	
	String message() default "{invalidAgeMessage}";

	int lower() default 18;

	int upper() default 60;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
