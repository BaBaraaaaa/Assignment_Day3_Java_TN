package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.com.vti.entity.Account;

public interface IAccountRepository extends JpaRepository<Account, Integer>{
	public Account findByName(String name);
	
}
