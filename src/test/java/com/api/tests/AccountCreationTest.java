package com.api.tests;

import java.net.PasswordAuthentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description="verify create user is working")
	public void createAccountTest() {
		SignUpRequest signUpRequest=new  SignUpRequest.Builder()
		.username("testmukesh123")
		.firstName("mukesh")
		.lastName("test")
		.password("12345678")
		.email("testtest@gmail.com")
		.mobileNumber("7777777777")
		.build();
		
		AuthService authService= new AuthService();
		Response response =authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
