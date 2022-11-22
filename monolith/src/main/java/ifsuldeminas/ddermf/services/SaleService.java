package ifsuldeminas.ddermf.services;

import ifsuldeminas.ddermf.dto.SaleDto;
import ifsuldeminas.ddermf.dto.SaleSuccessDto;
import ifsuldeminas.ddermf.dto.SaleSumDto;
import ifsuldeminas.ddermf.entities.Sale;
import ifsuldeminas.ddermf.repositories.SaleRepository;
import ifsuldeminas.ddermf.repositories.SellerRepository;
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
	public Page<SaleDto> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(SaleDto::new);
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDto> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDto> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}
}