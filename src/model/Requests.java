package model;


public class Requests {
	private String requestID = null;
	private String itemID = null;
	private String ownerID = null;
	private String borrowerID = null;
	private String period = null;
	private String date = null;
	private String response = null;
	
	public String getRequestID() {
		return requestID;
	}
	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	public String getBorrowerID() {
		return borrowerID;
	}
	public void setBorrowerID(String borrowerID) {
		this.borrowerID = borrowerID;
	}
	public String getPeriod() {
		return period;
	}
	public void setPeriod(String period) {
		this.period = period;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
}
