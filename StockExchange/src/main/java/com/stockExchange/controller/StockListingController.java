package com.stockExchange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockExchange.Entity.StockEntity;
import com.stockExchange.dao.StockListingService;
import com.stockExchange.dto.StockModel;
import com.stockExchange.utils.BaseResponse;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/stocks")
public class StockListingController {

	@Autowired
	private StockListingService stockService;

	/*
	 * End-point to fetch all available stocks.
	 *
	 * @return ResponseEntity with a list of StockModel and HTTP status
	 */
	
	@GetMapping("/list")
	public ResponseEntity<BaseResponse> getAllStocks() {
		try {
			// Fetch the list of stocks from the service
			 
			
			List<StockModel> stocks = stockService.getAvailableStocks();

			// Create a success response
			
			BaseResponse response = new BaseResponse();
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Stocks fetched successfully");
			response.setData(stocks);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			
			// Handle any exceptions and return an error response
			
			BaseResponse response = new BaseResponse();
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setMessage("Error fetching stocks");
			response.setData(null);

			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
