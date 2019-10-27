package com.tourneyhandler.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tourneyhandler.entities.User;
import com.tourneyhandler.repository.IUserRepository;
import com.tourneyhandler.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepository userRepository; 
	
	@Transactional
	@Override
	public User save(User t) throws Exception {
		return userRepository.save(t);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		userRepository.deleteById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<User> findById(Integer id) throws Exception {
		return userRepository.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<User> findAll() throws Exception {
		return userRepository.findAll();
	}
}