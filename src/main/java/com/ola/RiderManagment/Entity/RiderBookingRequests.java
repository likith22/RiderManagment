package com.ola.RiderManagment.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ola.RiderManagment.Template.RiderBookingRequestTemplate;

@Entity
@Table(name = "rider_booking_requets")
public class RiderBookingRequests {
	
	@Id
	@Column(name = "transaction_id")
	private int transactionId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_current_location")
	private String userCurrentLocation;
	@Column(name = "user_destination")
	private String userDestination;
	@Column(name = "ride_cost")
	private String rideCost;
	@Column(name = "confirmation_status")
	private String confirmationStatus;
	@Column(name = "rider_name")
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
	
	
	public static RiderBookingRequestTemplate convertToTemplate(
			RiderBookingRequests entity) {
		
		RiderBookingRequestTemplate template = new RiderBookingRequestTemplate();
		
		template.setTransactionId(entity.getTransactionId());
		template.setUserName(entity.getUserName());
		template.setUserCurrentLocation(entity.getUserCurrentLocation());
		template.setUserDestination(entity.getUserDestination());
		template.setRideCost(entity.getRideCost());
		template.setConfirmationStatus(entity.getConfirmationStatus());
		template.setRiderName(entity.getRiderName());
		
		return template;
		
	}
}
