package com.api.models.response;

public class VerifyUPIResponse {

	private String userName;
	private String isValid;
	private String bankName;
	
	public VerifyUPIResponse() {
		
	}
	
	public VerifyUPIResponse(String userName, String isValid, String bankName) {
		super();
		this.userName = userName;
		this.isValid = isValid;
		this.bankName = bankName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "VerifyUPIResponse [userName=" + userName + ", isValid=" + isValid + ", bankName=" + bankName + "]";
	}
	
	
}
