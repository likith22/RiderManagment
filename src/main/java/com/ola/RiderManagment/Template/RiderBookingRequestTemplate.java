package com.ola.RiderManagment.Template;

import com.ola.RiderManagment.Entity.RiderBookingRequests;

public class RiderBookingRequestTemplate {
	
	
	private int transactionId;
	
	private String userName;

	private String userCurrentLocation;

	private String userDestination;
	
	private String rideCost;

	private String confirmationStatus;
	
	private String riderName;
	
	
	public String getRiderName() {
		return riderName;
	}
	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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
	public String getRideCost() {
		return rideCost;
	}
	public void setRideCost(String rideCost) {
		this.rideCost = rideCost;
	}
	public String getConfirmationStatus() {
		return confirmationStatus;
	}
	public void setConfirmationStatus(String confirmationStatus) {
		this.confirmationStatus = confirmationStatus;
	}
	
	public static RiderBookingRequests convertToEntity(
			RiderBookingRequestTemplate template) {
		
		RiderBookingRequests entity = new RiderBookingRequests();
		
		entity.setTransactionId(template.getTransactionId());
		entity.setUserName(template.getUserName());
		entity.setUserCurrentLocation(template.getUserCurrentLocation());
		entity.setUserDestination(template.getUserDestination());
		entity.setRideCost(template.getRideCost());
		entity.setConfirmationStatus(template.getConfirmationStatus());
		entity.setRiderName(template.getRiderName());
		
		return entity;
		
	}
}
