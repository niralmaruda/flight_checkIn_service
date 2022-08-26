package com.niral.flightcheckin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niral.flightcheckin.integration.ReservationRestClient;
import com.niral.flightcheckin.integration.dto.Reservation;
import com.niral.flightcheckin.integration.dto.UpdateReservationRequest;

@Controller
public class CheckinController {
	
	@Autowired
	private ReservationRestClient restClient;
	
	@RequestMapping("/showStartCheckin")
	public String showStartCheckin() {
		System.out.println("inside /showStartCheckin()");
		return "startCheckIn";
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long reservationId, ModelMap modelMap) {
		
		Reservation reservation = restClient.findReservation(reservationId);
		System.out.println("inside startCheckIn()");
		modelMap.addAttribute("reservation", reservation);
		return "displayReservationDetails";
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId") Long reservationId,
									@RequestParam("numberOfBags") int numberOfBags) {
		UpdateReservationRequest updateReservationRequest = new UpdateReservationRequest();
		updateReservationRequest.setId(reservationId);
		updateReservationRequest.setNumberOfBags(numberOfBags);
		updateReservationRequest.setCheckedIn(true);
		restClient.updateReservation(updateReservationRequest);
		return "checkInConfirmation";
	}
}
