package com.tourneyhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourneyhandler.entities.Match;

@Repository
public interface IMatchRepository extends JpaRepository<Match, Integer> {
	
}