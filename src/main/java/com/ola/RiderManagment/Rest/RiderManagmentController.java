package com.ola.RiderManagment.Rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ola.RiderManagment.Entity.RiderBookingRequests;
import com.ola.RiderManagment.Service.RiderBookingRequestsService;
import com.ola.RiderManagment.Template.RequestBody1;

@RestController
@RequestMapping("api/v1")
public class RiderManagmentController {
	
	@Autowired
	RiderBookingRequestsService service;
	
	@PostMapping("/riderManagment")
	public ResponseEntity<?> savingRequest(@RequestBody RequestBody1 template){
		
		service.RiderBookingRequest(template.getTransactionId(),
				template.getUserName(),
				template.getUserCurrentLocation(),
				template.getUserDestination(),
				template.getRiderName());
		
		Map<String, String> response = new HashMap<>();
		response.put("status code","200");
		response.put("status", "sucess");
		response.put("message", "Request is pending with Rider.");
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	@GetMapping("/riderManagment/riderName/{riderName}/activeRequests")
	public ResponseEntity<?> activeRequests(@PathVariable("riderName") 
	String riderName){
		Map<String,String> response = new HashMap<>();
 		if(riderName == null) {
 			response.put("StatusCode", "400");
 			response.put("status", "BAD REQUEST");
 			response.put("message","Rider Name cannot be empty");
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
 		else {
 			List<RiderBookingRequests> result =service.getActiveRequests(riderName);
 			return new ResponseEntity<>(result,HttpStatus.OK);
 		}
		
	}
	@PutMapping("/riderMagangment/userName/{userName}/status/{confirmationStatus}/updateStatus")
	public ResponseEntity<?> updateConfirmationStatus(@PathVariable("userName")
	String userName,@PathVariable("confirmationStatus") String status){
		this.service.updateConfirmationStatus(userName, status);
		
		Map<String,Object> response =new HashMap<>();
			response.put("StatusCode", "200");
			response.put("status", "Success");
			response.put("message","succesfully "+status+" the request");
			
			return new ResponseEntity<>(response,HttpStatus.OK);
	}
		
}