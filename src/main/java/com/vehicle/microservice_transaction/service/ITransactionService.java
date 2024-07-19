package com.vehicle.microservice_transaction.service;

import com.vehicle.microservice_transaction.entity.Transaction;

import java.util.List;

public interface ITransactionService {


    Transaction createTransaction(Transaction transaction);

    void deleteTransaction(Long transactionId);

    List<Transaction> findAllTransactionsOfUser(Long userId);
}
