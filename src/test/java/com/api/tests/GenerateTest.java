package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UPIController;
import com.api.models.GenerateRequest;
import com.api.models.InitiateRequest;
import com.api.models.LoginRequest;
import com.api.models.response.GenerateResponse;
import com.api.models.response.InitiateResponse;
import com.api.models.response.LoginResponse;
import com.api.utils.ConfigReader;

import io.restassured.response.Response;

public class GenerateTest {

	
	

	@Test(description = "verify generate qr code test")
	public void generateQRCodeTest() {

		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest(ConfigReader.get("username"), ConfigReader.get("password")));
		LoginResponse loginResponse= response.as(LoginResponse.class);

		
		GenerateRequest generateRequest = new GenerateRequest.Builder()
				.merchantVpa("test@okhdfcbank")
				.merchantName("Merchant")
				.amount(200)
				.transactionNote("qr code generation test")
				.build();
		
		UPIController upiController = new UPIController();
		response = upiController.generate(loginResponse.getToken(), generateRequest);
		GenerateResponse generateResponse= response.as(GenerateResponse.class);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(200, response.getStatusCode());
	}
}
