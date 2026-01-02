package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.LoginRequest;
import com.api.utils.ConfigReader;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	static {
        RestAssured.filters(new LoggingFilter());
    }
	
	private static final String BASE_URL =ConfigReader.get("baseUrl");
	private RequestSpecification requestSpecification;
	
	public BaseService() {
		requestSpecification= given().baseUri(BASE_URL);
		
	} 
	
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization","Bearer "+token);
		
		
	}
	
	protected Response postRequest(Object payload,String endpoint) {
		 return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	protected Response putRequest(Object payload,String endpoint) {
		 return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}

	protected Response getRequest(String endpoint) {
		 return requestSpecification.contentType(ContentType.JSON).get(endpoint);
	}
}
