package com.tourney.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="match")
public class Match {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="winner", nullable=false)
	private Integer winner;
	
	@Column(name="participant1", nullable=false)
	private Integer participant1;
	
	@Column(name="participant2", nullable=false)
	private Integer participant2;
	
	@Column(name="tournament",  nullable=false)
	private Integer tournament;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWinner() {
		return winner;
	}

	public void setWinner(Integer winner) {
		this.winner = winner;
	}

	public Integer getParticipant1() {
		return participant1;
	}

	public void setParticipant1(Integer participant1) {
		this.participant1 = participant1;
	}

	public Integer getParticipant2() {
		return participant2;
	}

	public void setParticipant2(Integer participant2) {
		this.participant2 = participant2;
	}

	public Integer getTournament() {
		return tournament;
	}

	public void setTournament(Integer tournament) {
		this.tournament = tournament;
	}
	
	
}
