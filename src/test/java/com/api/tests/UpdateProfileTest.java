package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.ProfileRequest;
import com.api.models.response.UserProfileResponse;
import com.api.utils.ConfigReader;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test(description = "verify update profile test")
	public void updatePofileTest() {

		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest(ConfigReader.get("username"), ConfigReader.get("password")));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		
		System.out.println("------------------------------------------------------------");

		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		UserProfileResponse userProfileResponse =response.as(UserProfileResponse.class);
		
		
		System.out.println(response.asPrettyString());
		System.out.println("------------------------------------------------------------");

		
		ProfileRequest profileRequest = new ProfileRequest.Builder()
				.firstName("fasfdsa")
				.lastName("lastname")
				.email("test@gmail.com")
				.mobileNumber("9686968696")
				.build();
		
		response=	userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
