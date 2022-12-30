package com.ola.RiderManagment.Template;

public class RequestBody1 {
	private int TransactionId;
	private String userName;
	private String userCurrentLocation;
	private String userDestination;
	private String riderName;
	
	public String getRiderName() {
		return riderName;
	}
	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}
	public int getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCurrentLocation() {
		return userCurrentLocation;
	}
	public void setUserCurrentLocation(String userCurrentLocation) {
		this.userCurrentLocation = userCurrentLocation;
	}
	public String getUserDestination() {
		return userDestination;
	}
	public void setUserDestination(String userDestination) {
		this.userDestination = userDestination;
	}
	
	
}
