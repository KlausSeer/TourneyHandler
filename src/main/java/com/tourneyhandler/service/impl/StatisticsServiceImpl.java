package com.tourneyhandler.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourneyhandler.entities.Statistics;
import com.tourneyhandler.repository.IStatisticsRepository;
import com.tourneyhandler.service.IStatisticsService;

@Service
public class StatisticsServiceImpl implements IStatisticsService {

	@Autowired
	private IStatisticsRepository statisticsRepository; 
	
	@Transactional
	@Override
	public Statistics save(Statistics t) throws Exception {
		return statisticsRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		statisticsRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Statistics> findById(Integer id) throws Exception {
		return statisticsRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Statistics> findAll() throws Exception {
		return statisticsRepository.findAll();
	}
}