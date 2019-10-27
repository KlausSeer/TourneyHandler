package com.tourneyhandler.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourneyhandler.entities.Phase;
import com.tourneyhandler.repository.IPhaseRepository;
import com.tourneyhandler.service.IPhaseService;

@Service
public class PhaseServiceImpl implements IPhaseService {

	@Autowired
	private IPhaseRepository phaseRepository; 
	
	@Transactional
	@Override
	public Phase save(Phase t) throws Exception {
		return phaseRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		phaseRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Phase> findById(Integer id) throws Exception {
		return phaseRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Phase> findAll() throws Exception {
		return phaseRepository.findAll();
	}
}