package com.tourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourney.entities.Tournament;


@Repository
public interface ITournamentRepository extends JpaRepository<Tournament, Integer>{

}
