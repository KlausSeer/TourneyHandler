package com.tourneyhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourneyhandler.entities.Phase;

@Repository
public interface IPhaseRepository extends JpaRepository<Phase, Integer> {
}