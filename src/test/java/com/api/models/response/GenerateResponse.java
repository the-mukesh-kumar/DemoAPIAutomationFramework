package com.api.models.response;

public class GenerateResponse {
	private String expiresIn;
	private int amount;
	private String qrCodeData;
	private String qrCodeRef;
	private String upiUrl;
	private String merchantVpa;
	
	public GenerateResponse(){
		
	}
	public GenerateResponse(String expiresIn, int amount, String qrCodeData, String qrCodeRef, String upiUrl,
			String merchantVpa) {
		super();
		this.expiresIn = expiresIn;
		this.amount = amount;
		this.qrCodeData = qrCodeData;
		this.qrCodeRef = qrCodeRef;
		this.upiUrl = upiUrl;
		this.merchantVpa = merchantVpa;
	}
	public String getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(String expiresIn) {
		this.expiresIn = expiresIn;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getQrCodeData() {
		return qrCodeData;
	}
	public void setQrCodeData(String qrCodeData) {
		this.qrCodeData = qrCodeData;
	}
	public String getQrCodeRef() {
		return qrCodeRef;
	}
	public void setQrCodeRef(String qrCodeRef) {
		this.qrCodeRef = qrCodeRef;
	}
	public String getUpiUrl() {
		return upiUrl;
	}
	public void setUpiUrl(String upiUrl) {
		this.upiUrl = upiUrl;
	}
	public String getMerchantVpa() {
		return merchantVpa;
	}
	public void setMerchantVpa(String merchantVpa) {
		this.merchantVpa = merchantVpa;
	}
	@Override
	public String toString() {
		return "GenerateResponse [expiresIn=" + expiresIn + ", amount=" + amount + ", qrCodeData=" + qrCodeData
				+ ", qrCodeRef=" + qrCodeRef + ", upiUrl=" + upiUrl + ", merchantVpa=" + merchantVpa + "]";
	}
	
	
}
