package com.pk.netcalculation.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pk.netcalculation.service.NetCalculationService;

@RestController
public class NetCalculationController {
	
	@Autowired
	NetCalculationService netCalculationService;

	@GetMapping("/calculateNetPrice")
	public ResponseEntity<Object> calculateNetPrice(@RequestParam(value = "grossPrice", defaultValue = "0") String grossPrice, 
			@RequestParam(value = "countryIso") String countryIso) {
		
		if (!StringUtils.hasLength(countryIso)) {
			return new ResponseEntity<Object>(
			          "CountryISO is not provided", new HttpHeaders(), HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Object>(netCalculationService.calculateNetPrice(grossPrice, countryIso), new HttpHeaders(), HttpStatus.ACCEPTED);
	}

}
