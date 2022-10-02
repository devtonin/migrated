package com.ifsuldeminas.salems.controller;

import com.ifsuldeminas.metricsms.dto.SaleSuccessDTO;
import com.ifsuldeminas.metricsms.dto.SaleSumDTO;
import com.ifsuldeminas.salems.dto.SaleDTO;
import com.ifsuldeminas.salems.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	@GetMapping
	public ResponseEntity<SaleDTO> findAll() {
		SaleDTO list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping
	public ResponseEntity<SaleSumDTO> findAmountGroupedBySeller() {
		SaleSumDTO list = service.findAmountGroupedBySeller();
		return ResponseEntity.ok(list);
	}

	@GetMapping
	public ResponseEntity<SaleSuccessDTO> findSuccessGroupedBySeller() {
		SaleSuccessDTO list = service.findSuccessGroupedBySeller();
		return ResponseEntity.ok(list);
	}

}