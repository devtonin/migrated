package com.ifsuldeminas.salems.service;

import com.ifsuldeminas.metricsms.dto.SaleSuccessDTO;
import com.ifsuldeminas.metricsms.dto.SaleSumDTO;
import com.ifsuldeminas.salems.dto.SaleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

public interface SaleService {
	Page<SaleDTO> findAll(Pageable pageable);

	@GetMapping(value = "/metrics/amount-by-seller")
	SaleSumDTO findAmountGroupedBySeller();

	@GetMapping(value = "/metrics/success-by-seller")
	SaleSuccessDTO findSuccessGroupedBySeller();
}