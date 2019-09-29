package com.tourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourney.entities.Phase;

@Repository
public interface IPhaseRepository extends JpaRepository<Phase, Integer>{

}
