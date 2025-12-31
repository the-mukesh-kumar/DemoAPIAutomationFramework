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

public class GetStatusTest {

    @Test(description = "verify get status test")
    public void getStatusTest() {

        // 1️⃣ Login API
        AuthService authService = new AuthService();
		Response loginRes = authService.login(new LoginRequest(ConfigReader.get("username"), ConfigReader.get("password")));
        LoginResponse loginResponse = loginRes.as(LoginResponse.class);

        InitiateRequest initiateRequest = new InitiateRequest.Builder()
                .fromUpi("test@okhdfcbank")
                .toUpi("test1@okhdfcbank")
                .amount(100)
                .notes("for testing")
                .build();

        UPIController upiController = new UPIController();
		Response initiateRes = upiController.initiate(loginResponse.getToken(), initiateRequest);

		InitiateResponse initiateResponse = initiateRes.as(InitiateResponse.class);

        String transactionRef = initiateResponse.getTransactionRef();
       

        
		Response response = upiController.getStatus(loginResponse.getToken(), transactionRef);

       System.out.println(response.asPrettyString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
