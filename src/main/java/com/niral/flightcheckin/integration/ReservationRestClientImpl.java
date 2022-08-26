package com.niral.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.niral.flightcheckin.integration.dto.Reservation;
import com.niral.flightcheckin.integration.dto.UpdateReservationRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	private static final String RESERVATIONS_REST_URL = "http://localhost:8080/flightreservation/reservations/";

	@Override
	public Reservation findReservation(Long id) {
		System.out.println("inside findReservation()");
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("create restTemplate()");
		Reservation reservation = restTemplate.getForObject(RESERVATIONS_REST_URL + id, Reservation.class);
		System.out.println("create reservation");
		return reservation;
	}

	@Override
	public Reservation updateReservation(UpdateReservationRequest request) {
		RestTemplate restTemplate = new RestTemplate();
		Reservation reservation = restTemplate.postForObject(RESERVATIONS_REST_URL, request, Reservation.class);
		return reservation;
	}

}
