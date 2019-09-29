package com.tourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourney.entities.Team;



@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer>{

}
