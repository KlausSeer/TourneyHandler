package com.tourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourney.entities.Games;

@Repository
public interface IGamesRepository extends JpaRepository<Games, Integer>{

}
