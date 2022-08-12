package org.spring.app.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDto {

	@NotBlank(message = " * Your Name can't be blank")
//	@Min(value = 3, message = " * You have to enter at least 3 characters")
//	@Size(min = 3, max = 15, message = " * Your Name should have character between 3-15")
	@Size(min = 3, max = 15, message = "{userName.size}")
	private String userName;

	@NotBlank(message = " * Crush Name can't be blank")
//	@Min(value = 3, message = " * You have to enter at least 3 characters")
	@Size(min = 3, max = 15, message = " * Crush Name should have character between 3-15")
	private String crushName;

	@AssertTrue(message = " * You have to agree to use our App")
	private boolean termAndCondition;

	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public UserInfoDto() {
		System.out.println("UserInfoDto Constructor is called");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public boolean isTermAndCondition() {
		return termAndCondition;
	}

	public void setTermAndCondition(boolean termAndCondition) {
		this.termAndCondition = termAndCondition;
	}

	@Override
	public String toString() {
		return "UserInfoDto [userName=" + userName + ", crushName=" + crushName + ", termAndCondition="
				+ termAndCondition + "]";
	}

}
