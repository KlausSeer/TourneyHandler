package com.tourneyhandler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourneyhandler.entities.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
}