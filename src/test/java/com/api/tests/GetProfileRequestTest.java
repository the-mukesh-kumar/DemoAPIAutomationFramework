package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileRequestTest {

	@Test(description = "verify user profile is getting")
	public void getProfileInfoTest() {

		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("themukesh", "12345678"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());

		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		UserProfileResponse userProfileResponse =response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getUsername());
		System.out.println(response.asPrettyString());
	}
}
