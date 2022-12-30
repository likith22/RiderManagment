package com.ola.RiderManagment.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ola.RiderManagment.Entity.RiderBookingRequests;
import com.ola.RiderManagment.Repositories.RiderBookingRequestsRepository;
import com.ola.RiderManagment.Template.RiderBookingRequestTemplate;

@Service
public class RiderBookingRequestsServiceimpl 
implements RiderBookingRequestsService {
	
	@Autowired
	RiderBookingRequestsRepository repository;

	@Override
	public void RiderBookingRequest(int transactionId, String userName,
			String userCurrentLocation,String userDestination,String riderName) {
		String confirmationStatus = "Request is Pending";
		
		//Saving the Transaction into Data base : 
		
		RiderBookingRequestTemplate template = new RiderBookingRequestTemplate();
		
		template.setTransactionId(transactionId);
		template.setUserCurrentLocation(userCurrentLocation);
		template.setUserName(userName);
		template.setUserDestination(userDestination);
		template.setConfirmationStatus(confirmationStatus);
		template.setRiderName(riderName);
		
		this.repository.saveAndFlush(RiderBookingRequestTemplate.convertToEntity(template));
		
		
	}
	@Override
	public List<RiderBookingRequests> getActiveRequests(String riderName) {
		RiderBookingRequests[] requests =this.repository.findByRiderName(riderName);
		return Arrays.asList(requests);
	}
	@Override
	public void updateConfirmationStatus(String userName,String status) {
		//update the confirmation status:
		RiderBookingRequests request = this.repository.findByUserName(userName);
		request.setConfirmationStatus(status);
		this.repository.saveAndFlush(request);
		//String id = request.getTransactionId();
		//call back the service and update in the booking request db as well.
		String uri ="http://localhost:8092/api/v1/BookingRequest/transactionNumber/+"+request.getTransactionId()+"/status/"+status+"/updateBookingStatus";
		RestTemplate restCall = new RestTemplate();
		restCall.put(uri,"");
	}
}
