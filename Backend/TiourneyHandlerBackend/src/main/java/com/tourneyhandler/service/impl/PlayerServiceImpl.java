package com.tourneyhandler.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourneyhandler.entities.Player;
import com.tourneyhandler.repository.IPlayerRepository;
import com.tourneyhandler.service.IPlayerService;

@Service
public class PlayerServiceImpl implements IPlayerService {

	@Autowired
	private IPlayerRepository playerRepository; 
	
	@Transactional
	@Override
	public Player save(Player t) throws Exception {
		return playerRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		playerRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Player> findById(Integer id) throws Exception {
		return playerRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Player> findAll() throws Exception {
		return playerRepository.findAll();
	}
}