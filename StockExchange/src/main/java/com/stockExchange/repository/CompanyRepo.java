package com.stockExchange.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockExchange.Entity.CompanyEntity;

@Repository
public interface CompanyRepo extends JpaRepository<CompanyEntity, Integer>{
	
	Optional<CompanyEntity> findBySymbol(String symbol);

}
