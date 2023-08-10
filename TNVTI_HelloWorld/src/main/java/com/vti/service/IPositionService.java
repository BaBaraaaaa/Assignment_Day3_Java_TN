package com.vti.service;

import java.util.List;


import com.vti.com.vti.entity.Position;
import com.vti.form.PositionFormForCreating;
import com.vti.form.PostiontFormForUpdating;



public interface IPositionService {
	
	public List<Position> getAllPosition();

	public Position getPositionByID(int id);

	public Position getPositionByName(String name);

	public void createPosition(PositionFormForCreating form);

	public void updatePosition(int id, PostiontFormForUpdating form);

	public void deletePosition(int id);

	public boolean isPositiontExistsByID(int id);

	public boolean isPositionExistsByName(String name);
}
