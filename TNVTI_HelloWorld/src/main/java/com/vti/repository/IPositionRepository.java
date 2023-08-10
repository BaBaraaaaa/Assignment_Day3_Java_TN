package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.com.vti.entity.Position;

public interface IPositionRepository extends JpaRepository<Position, Integer>{

}
