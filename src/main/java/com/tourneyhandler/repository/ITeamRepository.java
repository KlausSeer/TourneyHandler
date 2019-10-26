package com.tourneyhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourneyhandler.entities.Team;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Integer> {
}