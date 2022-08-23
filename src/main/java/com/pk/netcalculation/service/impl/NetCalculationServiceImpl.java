package com.pk.netcalculation.service.impl;

import com.pk.netcalculation.service.NetCalculationService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service; 

@Service
public class NetCalculationServiceImpl implements NetCalculationService {

	
	private Map<String, Double> taxRate = new HashMap<String, Double>();
	
	NetCalculationServiceImpl() {
		this.taxRate.put("DE", 0.19);
		this.taxRate.put("FR", 0.20);
		this.taxRate.put("US", 0.30);
		this.taxRate.put("SW", 0.25);
		this.taxRate.put("IN", 0.15);
	}
	
	
	@Override
	public double calculateNetPrice(String grossPrice, String countryIso) {
		
		double gPrice = new Double(grossPrice).doubleValue();
		
		double incomeTaxRate = this.taxRate.get(countryIso);
		
		return gPrice - (incomeTaxRate * gPrice);
	   
	}

}
