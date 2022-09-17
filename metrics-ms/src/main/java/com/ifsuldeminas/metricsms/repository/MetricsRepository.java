package com.ifsuldeminas.metricsms.repository;

import com.ifsuldeminas.metricsms.dto.SaleSuccessDTO;
import com.ifsuldeminas.metricsms.dto.SaleSumDTO;
import com.ifsuldeminas.sellerms.entities.Sale;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// TODO: 17/09/2022 investigar se precisa alguma chamada pra outro ms aqui ou nessa service 
public interface MetricsRepository extends JpaRepository<Sale, Long> {

	@Query("SELECT new ifsuldeminas.metricsms.dto.SaleSumDto(obj.seller, SUM(obj.amount)) "
		+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();

	@Query("SELECT new ifsuldeminas.metricsms.dto.SaleSuccessDto(obj.seller, SUM(obj.visited), SUM(obj.deals))"
		+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}
