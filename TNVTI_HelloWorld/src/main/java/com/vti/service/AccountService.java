package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vti.com.vti.entity.Account;
import com.vti.com.vti.entity.Department;
import com.vti.com.vti.entity.Position;
import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IPositionRepository;
@Service
public class AccountService implements IAccountService{
	@Autowired

	private IAccountRepository accountRepository;
	
	 @Autowired
	 private IDepartmentRepository departmentRepository;
	 @Autowired
	 private IPositionRepository positionRepository;
	    
	@Override
	public List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public Account getAccounttByID(int id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id).get();
	}

	@Override
	public Account getAccountByName(String name) {
		// TODO Auto-generated method stub
		return accountRepository.findByName(name);
	}

	@Override
	public void createAccount(AccountFormForCreating form) {
		
		   Department department = departmentRepository.findById(form.getDepartment().getId()).get();
		   Position position = positionRepository.findById(form.getPosition().getId()).get();
		// chuyển từ form sang entity
				
				Account account = new Account(form.getEmail(),form.getUsername(),form.getName(),
						department,position,form.getCreateDate());
				accountRepository.save(account);
		
	}

	@Override
	public void updateAccount(int id, AccountFormForUpdating form) {
		// TODO Auto-generated method stub
		 Department department = departmentRepository.findById(form.getDepartment().getId()).get();
		 Position position = positionRepository.findById(form.getPosition().getId()).get();
		   Account acc = getAccounttByID(id);
		   
		   acc.setEmail(form.getEmail());
		   acc.setName(form.getName());
		   acc.setDepartment(department);
		   acc.setPosition(position);
		   accountRepository.save(acc);
		   
		   
	}

	@Override
	public void deleteAccount(int id) {
		// TODO Auto-generated method stub
		  Account acc = getAccounttByID(id);
		  accountRepository.delete(acc);
	}

	@Override
	public boolean isAccountExistsByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
