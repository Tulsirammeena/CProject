package com.stockExchange.Entity;

import java.util.Objects;

import jakarta.persistence.*;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity
@Table(name = "company")
public class CompanyEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer companyId;
	
	@Column(name = "name", nullable = false, length = 100)
    private String name;
	
	@Column(name = "symbol", nullable = false, unique = true, length = 10)
    private String symbol;
	
	@Column(name = "description", columnDefinition = "TEXT")
    private String description;
	
	// Getters and setters
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity company = (CompanyEntity) o;
        return Objects.equals(companyId, company.companyId) &&
               Objects.equals(name, company.name) &&
               Objects.equals(symbol, company.symbol) &&
               Objects.equals(description, company.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, name, symbol, description);
    }
    
    @Override
    public String toString() {
        return "Company{" +
               "companyId=" + companyId +
               ", name='" + name + '\'' +
               ", symbol='" + symbol + '\'' +
               ", description='" + description + '\'' +
               '}';
    }
	
}
