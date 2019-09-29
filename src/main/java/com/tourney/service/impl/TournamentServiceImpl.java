package com.tourney.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourney.entities.Tournament;
import com.tourney.repository.ITournamentRepository;
import com.tourney.service.ITournamentService;

@Service
public class TournamentServiceImpl implements ITournamentService {

	@Autowired
	private ITournamentRepository tournamentRepository; 
	
	@Transactional
	@Override
	public Tournament save(Tournament t) throws Exception {
		return tournamentRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		tournamentRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Tournament> findById(Integer id) throws Exception {
		return tournamentRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Tournament> findAll() throws Exception {
		return tournamentRepository.findAll();
	}
}
