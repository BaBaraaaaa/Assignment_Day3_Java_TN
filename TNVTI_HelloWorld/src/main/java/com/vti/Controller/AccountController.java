package com.vti.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.com.vti.entity.Account;
import com.vti.com.vti.entity.Department;
import com.vti.com.vti.entity.Position;
import com.vti.dto.AccountDto;

import com.vti.form.AccountFormForCreating;
import com.vti.form.AccountFormForUpdating;

import com.vti.service.IAccountService;
import com.vti.service.IDepartmentService;
import com.vti.service.IPositionService;

@RestController
@RequestMapping(value = "api/v1/Accounts")
@CrossOrigin("*")
public class AccountController {
	@Autowired
	private IAccountService service;
	@Autowired
	private IDepartmentService Depservice;
	@Autowired
	private IPositionService Positionservice;
	@GetMapping
	public ResponseEntity<?> getAllAccount()
	{
		List<Account> entityAccount = service.getAllAccount();
		
		List<AccountDto> AccDto = new ArrayList<>();
		
		
		for(Account entity : entityAccount)
		{
			Department dep = Depservice.getDepartmentByID(entity.getDepartment().getId());
			Position position = Positionservice.getPositionByID(entity.getPosition().getId());
			AccountDto accDto = new AccountDto(entity.getId(),entity.getEmail(),entity.getUsername(),
					entity.getName(),dep,entity.getPosition(),entity.getCreateDate());
//			accDto.setId(entity.getId());
//			accDto.setEmail(entity.getEmail());
//			accDto.setUsername(entity.getUsername());
//			accDto.setFullName(entity.getFullName());
//			accDto.setDepartment(entity.getDepartment());
//			accDto.setPosition(entity.getPosition());
			AccDto.add(accDto);
				
		}
		return new ResponseEntity<>(AccDto,HttpStatus.OK);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getAccounttByID(@PathVariable(name = "id") int id)
	{
		
		return new ResponseEntity<Account>(service.getAccounttByID(id),HttpStatus.OK); 
	}
	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreating form )
	{
	   
		service.createAccount(form);
		
		return new ResponseEntity<String>("Create Successfully!" , HttpStatus.OK);
		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateAccount(@PathVariable(name = "id" ) int id ,@RequestBody AccountFormForUpdating form)
	{
		service.updateAccount(id, form);
		return new ResponseEntity<String>("Update Successfully!" , HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDepartment (@PathVariable(name="id") int id)
	{
		service.deleteAccount(id);
		return new ResponseEntity<String>("Delete Successfully!" , HttpStatus.OK);
		
	}
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<?> getAccountByName(@PathVariable (name = "name") String name)
	{
		return new ResponseEntity<Account>(service.getAccountByName(name),HttpStatus.OK);
	}

}
