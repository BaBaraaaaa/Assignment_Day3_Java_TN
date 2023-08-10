package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.com.vti.entity.Account;
import com.vti.com.vti.entity.Position;
import com.vti.form.PositionFormForCreating;
import com.vti.form.PostiontFormForUpdating;
import com.vti.repository.IPositionRepository;
@Service
public class PositionService implements IPositionService{
	@Autowired
	private IPositionRepository positionRepository;
	@Override
	public List<Position> getAllPosition() {
		// TODO Auto-generated method stub
		return positionRepository.findAll();
	}

	@Override
	public Position getPositionByID(int id) {
		// TODO Auto-generated method stub
		return positionRepository.findById(id).get();
	}

	@Override
	public Position getPositionByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePosition(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPositiontExistsByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPositionExistsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createPosition(PositionFormForCreating form) {
		Position position = new Position(form.getName());
		positionRepository.save(position);
	}

	@Override
	public void updatePosition(int id, PostiontFormForUpdating form) {
		Position position = getPositionByID(id);
		position.setName(form.getName());
		positionRepository.save(position);
		
	}

}
