package com.tourneyhandler.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourneyhandler.entities.GameResults;
import com.tourneyhandler.repository.IGameResultsRepository;
import com.tourneyhandler.service.IGameResultsService;

@Service
public class GameResultsServiceImpl implements IGameResultsService {

	@Autowired
	private IGameResultsRepository gameResultsRepository; 
	
	@Transactional
	@Override
	public GameResults save(GameResults t) throws Exception {
		return gameResultsRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		gameResultsRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<GameResults> findById(Integer id) throws Exception {
		return gameResultsRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<GameResults> findAll() throws Exception {
		return gameResultsRepository.findAll();
	}
}