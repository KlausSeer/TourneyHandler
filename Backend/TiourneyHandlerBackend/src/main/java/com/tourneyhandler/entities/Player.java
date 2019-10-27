package com.tourneyhandler.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="players")
@Data
public class Player implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=3, message="El juego favorito debe tener un minimo de 3 caracteres")
	@Column(name="game_pref", length = 50, nullable = false)
	private String gamePref;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable = false)
	private Tournament user;
	
	@OneToOne
	@JoinColumn(name="statistics_id", nullable = false)
	private Tournament statistics;
	
	@ManyToOne
	@JoinColumn(name="team_id", nullable = true)
	private Team team;

}