package com.stockExchange.dto;


import java.math.BigDecimal;

import com.stockExchange.Entity.CompanyEntity;

import lombok.Data;

@Data
public class StockModel {
    //private Integer stockId;
    private String symbol;
    private String name;
    private BigDecimal price;
    private Long volume;

    // Getters and Setters
}
