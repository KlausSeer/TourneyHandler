package com.tourneyhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourneyhandler.entities.Statistics;

@Repository
public interface IStatisticsRepository extends JpaRepository<Statistics, Integer> {
}