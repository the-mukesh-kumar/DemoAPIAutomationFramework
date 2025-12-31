package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UPIController;
import com.api.models.InitiateRequest;
import com.api.models.LoginRequest;
import com.api.models.response.InitiateResponse;
import com.api.models.response.LoginResponse;
import com.api.utils.ConfigReader;

import io.restassured.response.Response;

public class InitiateTest {

	@Test(description = "initiate payment test")
	public void paymentInitiateTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest(ConfigReader.get("username"), ConfigReader.get("password")));
		LoginResponse loginResponse = response.as(LoginResponse.class);

		InitiateRequest initiateRequest = new InitiateRequest.Builder().fromUpi("test@okhdfcbank")
				.toUpi("test1@okhdfcbank").amount(100).notes("for testing").build();

		UPIController upiController = new UPIController();
		response = upiController.initiate(loginResponse.getToken(), initiateRequest);
		
		InitiateResponse initiateResponse=	response.as(InitiateResponse.class);
		System.out.println(initiateResponse.getTransactionRef());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
