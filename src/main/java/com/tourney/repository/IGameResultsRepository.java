package com.tourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourney.entities.GameResults;

@Repository
public interface IGameResultsRepository extends JpaRepository<GameResults, Integer>{
	
}
