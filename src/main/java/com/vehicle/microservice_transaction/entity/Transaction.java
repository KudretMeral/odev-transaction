package com.vehicle.microservice_transaction.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction extends BaseEntity{

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "transaction_time")
    private LocalDateTime transactionTime;


    public Transaction() {
    }

    public Transaction( Long userId, Long productId, LocalDateTime transactionTime) {
        this.userId = userId;
        this.productId = productId;
        this.transactionTime = transactionTime;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}
