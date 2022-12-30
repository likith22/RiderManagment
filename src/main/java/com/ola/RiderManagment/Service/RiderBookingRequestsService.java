package com.ola.RiderManagment.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ola.RiderManagment.Entity.RiderBookingRequests;

@Service
public interface RiderBookingRequestsService {
	
	public void RiderBookingRequest(int transactionId,String userName,
			String userCurrentLocation,String userDestination,String riderName);
	public List<RiderBookingRequests> getActiveRequests(String riderName);
	public void updateConfirmationStatus(String userName,String status);
}
