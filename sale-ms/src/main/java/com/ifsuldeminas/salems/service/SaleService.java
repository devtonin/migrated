package com.ifsuldeminas.salems.service;

import com.ifsuldeminas.metricsms.dto.SaleSuccessDTO;
import com.ifsuldeminas.metricsms.dto.SaleSumDTO;
import com.ifsuldeminas.salems.dto.SaleDTO;
import com.ifsuldeminas.salems.entities.Sale;
import com.ifsuldeminas.salems.repository.SaleRepository;
import com.ifsuldeminas.sellerms.repository.SellerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {


	@Autowired
	private SaleRepository repository;

	@Autowired
	private SellerRepository sellerRepository;

	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {

		// TODO: 17/09/2022
		sellerRepository.findAll();

		Page<Sale> result = repository.findAll(pageable);
		return result.map(SaleDTO::new);
	}

	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}

	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}
}