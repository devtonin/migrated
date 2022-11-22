package ifsuldeminas.ddermf.services;

import ifsuldeminas.ddermf.repositories.SellerRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifsuldeminas.ddermf.dto.SellerDto;
import ifsuldeminas.ddermf.entities.Seller;

@Service
public class SellerService {

	@Autowired
	private SellerRepository repository;
	
	public List<SellerDto> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(SellerDto::new).collect(Collectors.toList());
	}
}