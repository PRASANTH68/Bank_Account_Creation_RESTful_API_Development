package com.bank_restapi_creation.service;

import java.util.List;

import com.bank_restapi_creation.model.BankAccount;


public interface BankService {
	 List<BankAccount> getAllAccounts();
	 BankAccount getAccountById(Long id);
	 BankAccount createAccount(BankAccount account);
	 BankAccount updateAccount(Long id, BankAccount account);
	 void deleteAccount(Long id);
}
