package com.tourneyhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourneyhandler.entities.Tournament;

@Repository
public interface ITournamentRepository extends JpaRepository<Tournament, Integer> {
}