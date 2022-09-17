package com.ifsuldeminas.sellerms.repository;

import com.ifsuldeminas.sellerms.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

}