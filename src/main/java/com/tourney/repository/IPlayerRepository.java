package com.tourney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourney.entities.Player;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Integer> {

}
