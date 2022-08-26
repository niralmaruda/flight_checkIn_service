package com.niral.flightcheckin.integration;

import com.niral.flightcheckin.integration.dto.Reservation;
import com.niral.flightcheckin.integration.dto.UpdateReservationRequest;

public interface ReservationRestClient {
	
	
	public Reservation findReservation(Long id);
	
	public Reservation updateReservation(UpdateReservationRequest request);

}
