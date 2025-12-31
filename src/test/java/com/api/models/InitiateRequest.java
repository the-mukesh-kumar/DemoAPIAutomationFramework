package com.api.models;

public class InitiateRequest {
	private String fromUpi; 
	private String  toUpi; 
	private int  amount;
	private String  note;
	 
	public InitiateRequest(String fromUpi, String toUpi, int amount, String note) {
		super();
		this.fromUpi = fromUpi;
		this.toUpi = toUpi;
		this.amount = amount;
		this.note = note;
	}
	public String getFromUpi() {
		return fromUpi;
	}
	public void setFromUpi(String fromUpi) {
		this.fromUpi = fromUpi;
	}
	public String getToUpi() {
		return toUpi;
	}
	public void setToUpi(String toUpi) {
		this.toUpi = toUpi;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "InitiateRequest [fromUpi=" + fromUpi + ", toUpi=" + toUpi + ", amount=" + amount + ", note=" + note
				+ "]";
	} 
	
	
	public static class Builder {
		private String fromUpi; 
		private String  toUpi; 
		private int  amount;
		private String  note;
	
		public Builder fromUpi(String fromUpi) {
			this.fromUpi=fromUpi;
			return this;
		} 
		public Builder toUpi(String toUpi) {
			this.toUpi=toUpi;
			return this;
		}
		public Builder amount(int amount) {
			this.amount=amount;
			return this;
		}
		
		public Builder notes(String note) {
			this.note=note;
			return this;
		}
		
		public InitiateRequest build() {
			InitiateRequest initiateRequest= new InitiateRequest(fromUpi, toUpi, amount, note) ;
				return initiateRequest;
			
		}
	}
	
	
}
