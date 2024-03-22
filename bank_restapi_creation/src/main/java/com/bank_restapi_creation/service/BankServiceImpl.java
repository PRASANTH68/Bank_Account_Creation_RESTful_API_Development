package com.bank_restapi_creation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank_restapi_creation.model.BankAccount;
import com.bank_restapi_creation.repository.BankAccountRepository;

@Service
public class BankServiceImpl implements BankService{
	@Autowired
    private BankAccountRepository bankAccountRepository;

	@Override
	public List<BankAccount> getAllAccounts() {
		// TODO Auto-generated method stub
		return bankAccountRepository.findAll();
	}

	@Override
	public BankAccount getAccountById(Long id) {
		// TODO Auto-generated method stub
		Optional<BankAccount> account = bankAccountRepository.findById(id);
        return account.orElse(null);
	}

	@Override
	public BankAccount createAccount(BankAccount account) {
		// TODO Auto-generated method stub
		return bankAccountRepository.save(account);
	}

	@Override
	public BankAccount updateAccount(Long id, BankAccount account) {
		// TODO Auto-generated method stub
		account.setId(id);
        return bankAccountRepository.save(account);
	}

	@Override
	public void deleteAccount(Long id) {
		// TODO Auto-generated method stub
		bankAccountRepository.deleteById(id);
	}
}
