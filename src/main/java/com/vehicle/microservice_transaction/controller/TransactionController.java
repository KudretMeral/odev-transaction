package com.vehicle.microservice_transaction.controller;

import com.vehicle.microservice_transaction.entity.Transaction;
import com.vehicle.microservice_transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/transaction")
public class TransactionController
{
    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/createTransaction")
    public ResponseEntity<?> createTransaction(@RequestBody Transaction transaction)
    {
        return new ResponseEntity<>(transactionService.createTransaction(transaction), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteTransaction/{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId)
    {
        transactionService.deleteTransaction(transactionId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllTransactionsOfUser/{userId}")
    public ResponseEntity<?> getAllTransactionsOfUser(@PathVariable Long userId)
    {
        return ResponseEntity.ok(transactionService.findAllTransactionsOfUser(userId));
    }
}