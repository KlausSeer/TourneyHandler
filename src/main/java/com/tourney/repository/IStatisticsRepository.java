package com.tourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourney.entities.Statistics;


@Repository
public interface IStatisticsRepository extends JpaRepository<Statistics, Integer>{

}
