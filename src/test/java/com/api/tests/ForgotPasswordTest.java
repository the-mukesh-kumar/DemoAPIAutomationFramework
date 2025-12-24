package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordTest {
	
	@Test(description="verify forgot password")
	public void forgotPasswordTest() {
		AuthService authService = new AuthService();
		Response response =authService.forgotPassword("testtest@gmail.com");
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
