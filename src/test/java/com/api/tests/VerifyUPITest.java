package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UPIController;
import com.api.models.LoginRequest;
import com.api.models.VerifyUpiRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.VerifyUPIResponse;
import com.api.utils.ConfigReader;

import io.restassured.response.Response;

public class VerifyUPITest {

	
	@Test(description = "verify upi id")
	public void verifyUPITest() {
		
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest(ConfigReader.get("username"), ConfigReader.get("password")));
		LoginResponse loginResponse = response.as(LoginResponse.class);
	
		
		 VerifyUpiRequest verifyUpiRequest = new VerifyUpiRequest("test@okhdfcbank");

		    UPIController upiController = new UPIController();
		    response = upiController.verify(loginResponse.getToken(), verifyUpiRequest);

		 VerifyUPIResponse verifyUPIResponse = response.as(VerifyUPIResponse.class);
		 Assert.assertEquals(response.getStatusCode(), 200);
		 System.out.println(response.asPrettyString());
		// verifyUPIResponse.getBankName();
		 System.out.println(verifyUPIResponse.getBankName());
		 
	}
}
