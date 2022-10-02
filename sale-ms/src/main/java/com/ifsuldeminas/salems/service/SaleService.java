package com.ifsuldeminas.salems.service;

import com.ifsuldeminas.metricsms.dto.SaleSuccessDTO;
import com.ifsuldeminas.metricsms.dto.SaleSumDTO;
import com.ifsuldeminas.salems.dto.SaleDTO;
import org.springframework.web.bind.annotation.GetMapping;

public interface SaleService {
	@GetMapping(value = "/sellers")
	SaleDTO findAll();

	@GetMapping(value = "/metrics/amount-by-seller")
	SaleSumDTO findAmountGroupedBySeller();

	@GetMapping(value = "/metrics/success-by-seller")
	SaleSuccessDTO findSuccessGroupedBySeller();
}