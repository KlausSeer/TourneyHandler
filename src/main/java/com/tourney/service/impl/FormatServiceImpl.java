package com.tourney.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourney.entities.Format;
import com.tourney.repository.IFormatRepository;
import com.tourney.service.IFormatService;

@Service
public class FormatServiceImpl implements IFormatService {

	@Autowired
	private IFormatRepository formatRepository; 
	
	@Transactional
	@Override
	public Format save(Format t) throws Exception {
		return formatRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		formatRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Format> findById(Integer id) throws Exception {
		return formatRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Format> findAll() throws Exception {
		return formatRepository.findAll();
	}
}
