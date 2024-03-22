package com.bank_restapi_creation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank_restapi_creation.model.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount,Long>{

}
