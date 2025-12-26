package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;
@Listeners(com.api.listenres.TestListener.class)
public class LoginAPITest {

	@Test(description = "verify login api is working")
	public void loginTest() {

		LoginRequest loginRequest = new LoginRequest("themukesh", "12345678");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		LoginResponse loginResponse = response.as(LoginResponse.class);

		System.out.println(loginResponse.getToken());
		Assert.assertTrue(loginResponse.getToken() !=null);

	}

}
