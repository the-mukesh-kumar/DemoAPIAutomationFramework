package com.api.models.response;

public class InitiateResponse {
private String transactionRef;
private String message;
private String status;

public InitiateResponse() {
	
}
public InitiateResponse(String transactionRef, String message, String status) {
	super();
	this.transactionRef = transactionRef;
	this.message = message;
	this.status = status;
}
public String getTransactionRef() {
	return transactionRef;
}
public void setTransactionRef(String transactionRef) {
	this.transactionRef = transactionRef;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "InitiateResponse [transactionRef=" + transactionRef + ", message=" + message + ", status=" + status + "]";
}


}
