package com.api.models;

public class VerifyUpiRequest {

	 private String upiId;

	    public VerifyUpiRequest(String upiId) {
	        this.upiId = upiId;
	    }

	    public String getUpiId() {
	        return upiId;
	    }

	    public void setUpiId(String upiId) {
	        this.upiId = upiId;
	    }

	    @Override
	    public String toString() {
	        return "VerifyUpiRequest [upiId=" + upiId + "]";
	    }
	
	
}
