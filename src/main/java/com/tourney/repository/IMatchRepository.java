package com.tourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourney.entities.Match;

@Repository
public interface IMatchRepository extends JpaRepository<Match, Integer> {

}
