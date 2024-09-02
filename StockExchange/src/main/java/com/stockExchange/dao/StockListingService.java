package com.stockExchange.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockExchange.Entity.StockEntity;
import com.stockExchange.dto.StockModel;
import com.stockExchange.repository.StockRepo;

@Service
public class StockListingService {

    @Autowired
    private StockRepo stockRepository;

    /**
     * Fetches all available stocks from the database and converts them to StockModel.
     *
     * @return List of StockModel
     */
    public List<StockModel> getAvailableStocks() {
        // Fetch stocks from the repository
        List<StockEntity> stockEntities = stockRepository.findAll();
        
        // Convert entities to models
        return stockEntities.stream()
                .map(this::convertToModel)
                .collect(Collectors.toList());
    }

    /**
     * Converts a StockEntity to a StockModel.
     *
     * @param stockEntity the StockEntity to convert
     * @return the converted StockModel
     */
    private StockModel convertToModel(StockEntity stockEntity) {
        StockModel stockModel = new StockModel();
        //stockModel.setStockId(stockEntity.getStockId());
        stockModel.setSymbol(stockEntity.getCompany() != null ? stockEntity.getCompany().getSymbol() : null);
        stockModel.setName(stockEntity.getCompany() != null ? stockEntity.getCompany().getName() : null);
        stockModel.setPrice(stockEntity.getPrice());
        stockModel.setVolume(stockEntity.getVolume());
        return stockModel;
    }
}
