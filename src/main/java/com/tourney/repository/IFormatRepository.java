package com.tourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourney.entities.Format;

@Repository
public interface IFormatRepository extends JpaRepository<Format, Integer>{
	
}
