package com.tourneyhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourneyhandler.entities.Player;

@Repository
public interface IPlayerRepository extends JpaRepository<Player, Integer> {
}