package com.ifsuldeminas.salems.service;

import com.ifsuldeminas.metricsms.dto.SaleSuccessDTO;
import com.ifsuldeminas.metricsms.dto.SaleSumDTO;
import com.ifsuldeminas.salems.dto.SaleDTO;
import com.ifsuldeminas.salems.repository.SaleRepository;
import com.ifsuldeminas.sellerms.repository.SellerRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SaleServiceImpl implements SaleService {

	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@Autowired
	private SaleRepository repository;

	@Autowired
	private SellerRepository sellerRepository;

	@HystrixCommand(fallbackMethod = "defaultSale")
	public SaleDTO findAll() {
		return restTemplate.getForObject("http://seller-ms/sellers", SaleDTO.class);
	}

	@HystrixCommand(fallbackMethod = "defaultSum")
	public SaleSumDTO findAmountGroupedBySeller() {
		return restTemplate.getForObject("http://metrics-ms/metrics/amount-by-seller", SaleSumDTO.class);
	}

	@HystrixCommand(fallbackMethod = "defaultSuccess")
	public SaleSuccessDTO findSuccessGroupedBySeller() {
		return restTemplate.getForObject("http://metrics-ms/metrics/success-by-seller", SaleSuccessDTO.class);
	}

	private SaleDTO defaultSale(Long id) {
		return new SaleDTO();
	}

	private SaleSumDTO defaultSum(Long id) {
		return new SaleSumDTO();
	}

	private SaleSuccessDTO defaultSuccess(Long id) {
		return new SaleSuccessDTO();
	}

}