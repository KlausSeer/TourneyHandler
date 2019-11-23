package com.tourneyhandler.service;

import java.util.List;

import com.tourneyhandler.entities.Player;

public interface IPlayerService extends CrudService<Player> {
	public List<Player> PlayGame(List<Player> prevMatch)throws Exception;
	
}