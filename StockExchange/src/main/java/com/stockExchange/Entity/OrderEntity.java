package com.stockExchange.Entity;


import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
 
@Entity
@Table(name = "orders")
public class OrderEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
 
    @ManyToOne
    @JoinColumn(name = "uniqueId", nullable = false)
    private UserEntity user;
 
	@ManyToOne
    @JoinColumn(name = "companyId", nullable = false)	
    private CompanyEntity company;
 
    @Enumerated(EnumType.STRING)
    @Column(name = "order_type", nullable = false)
    private OrderType orderType;
 
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
 
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
 
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;
 
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
 
    // Getters and setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
    
    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(user, that.user) &&
                Objects.equals(company, that.company) &&
                orderType == that.orderType &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(price, that.price) &&
                status == that.status &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, user, company, orderType, quantity, price, status, createdAt);
    }

   
    
    // equals and hashCode methods
 
    public enum OrderType {
        BUY, SELL
    }
 
    public enum OrderStatus {
        PENDING, EXECUTED, CANCELLED
    }
}
