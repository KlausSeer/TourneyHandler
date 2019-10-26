package com.tourneyhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourneyhandler.entities.GameResults;

@Repository
public interface IGameResultsRepository extends JpaRepository<GameResults, Integer> {
}