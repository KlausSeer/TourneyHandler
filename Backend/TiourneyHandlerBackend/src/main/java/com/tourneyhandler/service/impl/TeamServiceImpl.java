package com.tourneyhandler.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourneyhandler.entities.Team;
import com.tourneyhandler.repository.ITeamRepository;
import com.tourneyhandler.service.ITeamService;

@Service
public class TeamServiceImpl implements ITeamService {

	@Autowired
	private ITeamRepository teamRepository; 
	
	@Transactional
	@Override
	public Team save(Team t) throws Exception {
		return teamRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		teamRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Team> findById(Integer id) throws Exception {
		return teamRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Team> findAll() throws Exception {
		return teamRepository.findAll();
	}
}