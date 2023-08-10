package com.vti.service;

import java.util.List;

import com.vti.com.vti.entity.Account;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;


public interface IAccountService {
	public List<Account> getAllAccount();

	public Account getAccounttByID(int id);

	public Account getAccountByName(String name);

	public void createAccount(AccountFormForCreating form);

	public void updateAccount(int id,AccountFormForUpdating form);

	public void deleteAccount(int id);

	public boolean isAccountExistsByID(int id);

//	public boolean isAccountExistsByName(String name);
}
