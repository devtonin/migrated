package com.ifsuldeminas.sellerms.service;

import com.ifsuldeminas.sellerms.dto.SellerDTO;
import com.ifsuldeminas.sellerms.entities.Seller;
import com.ifsuldeminas.sellerms.repository.SellerRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;

	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(SellerDTO::new).collect(Collectors.toList());
	}
}