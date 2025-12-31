package com.api.base;

import com.api.models.GenerateRequest;
import com.api.models.InitiateRequest;
import com.api.models.VerifyUpiRequest;
import com.api.models.response.InitiateResponse;

import io.restassured.response.Response;

public class UPIController extends BaseService {
	private static final String BASE_PATH = "/api/upi/";

	public Response verify(String token, VerifyUpiRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH + "verify");

	}
	
	public Response initiate(String token, InitiateRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH + "payment/initiate");
	}
	
	public Response generate(String token, GenerateRequest payload) {
		setAuthToken(token);
		return postRequest(payload, BASE_PATH+"qr-code/generate");
	}
	
	public Response getStatus(String token , String  transactionRef) {
		setAuthToken(token);
		return getRequest(BASE_PATH+"payment/status/"+transactionRef);
	}
	
}