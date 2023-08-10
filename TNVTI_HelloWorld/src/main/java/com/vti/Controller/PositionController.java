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

import com.vti.com.vti.entity.Position;

import com.vti.dto.PositionDto;

import com.vti.form.PositionFormForCreating;
import com.vti.form.PostiontFormForUpdating;
import com.vti.service.IPositionService;

@RestController
@RequestMapping(value = "api/v1/Position")
@CrossOrigin("*")
public class PositionController {
	@Autowired
	private IPositionService Positionservice;

	@GetMapping
	public ResponseEntity<?> getAllPosition() {
		List<Position> entities = Positionservice.getAllPosition();
		List<PositionDto> Dedto = new ArrayList<>();
		// chuyển từ entites sang dto
		for (Position entity : entities) {
			PositionDto dto = new PositionDto(entity.getId(), entity.getName());
			Dedto.add(dto);
		}

		return new ResponseEntity<>(Dedto, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getPositionByID(@PathVariable(name = "id") int id) {

		return new ResponseEntity<Position>(Positionservice.getPositionByID(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createDepartment(@RequestBody PositionFormForCreating form) {
		Positionservice.createPosition(form);

		return new ResponseEntity<String>("Create Successfully!", HttpStatus.OK);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updatePosition(@PathVariable(name = "id") int id,
			@RequestBody PostiontFormForUpdating form) {
		Positionservice.updatePosition(id, form);
		return new ResponseEntity<String>("Update Successfully!", HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") int id) {
		Positionservice.deletePosition(id);
		return new ResponseEntity<String>("Delete Successfully!", HttpStatus.OK);

	}

	@GetMapping(value = "/name/{name}")
	public ResponseEntity<?> getDepartmentByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<Position>(Positionservice.getPositionByName(name), HttpStatus.OK);
	}
}
