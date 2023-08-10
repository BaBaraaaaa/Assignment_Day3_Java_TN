package com.vti.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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

import com.vti.com.vti.entity.Department;
import com.vti.dto.DepartmentDto;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {
	@Autowired
	private IDepartmentService service;
	
	@GetMapping
	public ResponseEntity<?> getAllDepartments()
	{
		List<Department> entities = service.getAllDepartments();
		List<DepartmentDto> Dedto = new ArrayList<>();
		// chuyển từ entites sang dto
		for (Department entity: entities)
		{
			DepartmentDto dto = new DepartmentDto(entity.getId(), entity.getName());
			Dedto.add(dto);
		}
		
		return new ResponseEntity<>(Dedto,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") int id)
	{
		
		return new ResponseEntity<Department>(service.getDepartmentByID(id),HttpStatus.OK); 
	}
	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentFormForCreating form )
	{
		service.createDepartment(form);
		
		return new ResponseEntity<String>("Create Successfully!" , HttpStatus.OK);
		
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id" ) int id ,@RequestBody DepartmentFormForUpdating form)
	{
		service.updateDepartment(id, form);
		return new ResponseEntity<String>("Update Successfully!" , HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDepartment (@PathVariable(name="id") int id)
	{
		service.deleteDepartment(id);
		return new ResponseEntity<String>("Delete Successfully!" , HttpStatus.OK);
		
	}
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<?> getDepartmentByName(@PathVariable (name = "name") String name)
	{
		return new ResponseEntity<Department>(service.getDepartmentByName(name),HttpStatus.OK);
	}

}
