package com.stockExchange.Entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
 
@Entity
@Table(name = "transactions")
public class TransactionEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
 
    @ManyToOne
    @JoinColumn(name = "buy_order_id")
    private OrderEntity buyOrder;
 
    @ManyToOne
    @JoinColumn(name = "sell_order_id")
    private OrderEntity sellOrder;
 
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
 
    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;
 
    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;
 
    // Getters and setters
    // equals and hashCode methods
}