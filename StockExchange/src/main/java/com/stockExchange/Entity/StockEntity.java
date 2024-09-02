package com.stockExchange.Entity;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "stock_prices")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor

public class StockEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer stockId;
	
	
	@ManyToOne
    @JoinColumn(name = "companyId", nullable = false)	
    private CompanyEntity company;
	
	@Column(name = "date", nullable = false)
    private LocalDate date;
	
	@Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
	
	@Column(name = "volume", nullable = false)
    private Long volume;
	
	// Getters and setters
    public Integer getStockId() {
        return stockId;
    }

    public void setPriceId(Integer stockId) {
        this.stockId = stockId;
    }

    public CompanyEntity getCompany() {
        return company;
    }
    
    

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public Long getVolume() {
        return volume;
    }

    public void setVolume(Long volume) {
        this.volume = volume;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockEntity that = (StockEntity) o;
        return Objects.equals(stockId, that.stockId) &&
               Objects.equals(company, that.company) &&
               Objects.equals(date, that.date) &&
               Objects.equals(price, that.price) &&
               Objects.equals(volume, that.volume);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(stockId, company, date, price, volume);
    }

    @Override
    public String toString() {
        return "StockPrice{" +
               "stockId=" + stockId +
               ", company=" + company +
               ", date=" + date +
               ", price=" + price +
               ", volume=" + volume +
               '}';
    }

}
