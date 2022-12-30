package com.ola.RiderManagment.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ola.RiderManagment.Entity.RiderBookingRequests;

@Repository
public interface RiderBookingRequestsRepository extends JpaRepository<RiderBookingRequests, Integer> {
	public RiderBookingRequests[] findByRiderName(String riderName);
	
	public RiderBookingRequests findByUserName(String userName);
}
