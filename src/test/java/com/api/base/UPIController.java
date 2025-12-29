package com.api.base;

import com.api.models.InitiateRequest;
import com.api.models.VerifyUpiRequest;

import io.restassured.response.Response;

public class UPIController extends BaseService {
	private static final String BASE_PATH = "/api/upi/";

	public Response postVerify(String token, VerifyUpiRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH + "verify");

	}
	
	public Response initiate(String token, InitiateRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH + "payment/verify");
	}
	
	
}