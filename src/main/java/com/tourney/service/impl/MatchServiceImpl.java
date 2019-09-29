package com.tourney.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourney.entities.Match;
import com.tourney.repository.IMatchRepository;
import com.tourney.service.IMatchService;

@Service
public class MatchServiceImpl implements IMatchService {

	@Autowired
	private IMatchRepository matchRepository; 
	
	@Transactional
	@Override
	public Match save(Match t) throws Exception {
		return matchRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		matchRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Match> findById(Integer id) throws Exception {
		return matchRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Match> findAll() throws Exception {
		return matchRepository.findAll();
	}
}
