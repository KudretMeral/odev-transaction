package com.vehicle.microservice_transaction.service;

import com.vehicle.microservice_transaction.entity.Transaction;
import com.vehicle.microservice_transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService implements ITransactionService
{
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction)
    {
        transaction.setTransactionTime(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(Long transactionId)
    {
        transactionRepository.deleteById(transactionId);
    }

    @Override
    public List<Transaction> findAllTransactionsOfUser(Long userId)
    {
        return transactionRepository.findAllByUserId(userId);
    }
}
