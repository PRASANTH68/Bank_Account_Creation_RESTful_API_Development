package com.bank_restapi_creation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank_restapi_creation.model.BankAccount;
import com.bank_restapi_creation.service.BankService;

@RestController
@RequestMapping("/api/accounts")
public class BankController {
	@Autowired
    private BankService bankService;

    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return bankService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccountById(@PathVariable Long id) {
        BankAccount account = bankService.getAccountById(id);
        if (account != null) {
            return new ResponseEntity<>(account, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount account) {
        BankAccount createdAccount = bankService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BankAccount> updateAccount(@PathVariable Long id, @RequestBody BankAccount account) {
        BankAccount updatedAccount = bankService.updateAccount(id, account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        bankService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
