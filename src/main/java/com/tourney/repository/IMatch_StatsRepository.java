package com.tourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourney.entities.Match_Stats;

@Repository
public interface IMatch_StatsRepository extends JpaRepository<Match_Stats, Integer> {

}
