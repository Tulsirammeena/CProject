package com.stockExchange.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockExchange.Entity.StockEntity;

@Repository
public interface StockRepo extends JpaRepository<StockEntity, Integer> {

	// Find all stocks with pagination support (requires an additional query if needed for pagination)
    @Query(value = "SELECT * FROM stock_prices s", nativeQuery = true)
    List<StockEntity> findAllStocks();
    
	// Find stocks by company symbol and date range
	@Query(value = "SELECT * FROM stock_prices s JOIN company c ON s.companyId = c.companyId WHERE c.symbol = :symbol AND s.date BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<StockEntity> findByCompanySymbolAndDateBetween(String symbol, LocalDate startDate, LocalDate endDate);


	// Find stocks by company name (case insensitive)
    @Query(value = "SELECT * FROM stock_prices s JOIN company c ON s.companyId = c.companyId WHERE LOWER(c.name) = LOWER(:companyName)", nativeQuery = true)
    List<StockEntity> findByCompanyCompanyNameIgnoreCase(String companyName);

    // Find stocks by stock symbol (case insensitive)
    @Query(value = "SELECT * FROM stock_prices s JOIN company c ON s.companyId = c.companyId WHERE LOWER(c.symbol) = LOWER(:symbol)", nativeQuery = true)
    List<StockEntity> findByCompanySymbolIgnoreCase(String symbol);
    
    // Find stocks by either company name or stock symbol (case insensitive)
    @Query(value = "SELECT * FROM stock_prices s JOIN company c ON s.companyId = c.companyId WHERE LOWER(c.name) = LOWER(:companyName) OR LOWER(s.symbol) = LOWER(:symbol)", nativeQuery = true)
    List<StockEntity> findByCompanyCompanyNameIgnoreCaseOrCompanySymbolIgnoreCase(String companyName, String symbol);
    
 // Find stocks by stock ID
    @Query(value = "SELECT * FROM stock_prices s WHERE s.stockId = :stockId", nativeQuery = true)
    Optional<StockEntity> findByStockId(Integer stockId);

    


}
