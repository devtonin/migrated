package com.ifsuldeminas.salems.repository;

import com.ifsuldeminas.salems.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
