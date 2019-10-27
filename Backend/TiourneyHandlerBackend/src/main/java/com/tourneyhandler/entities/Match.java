package com.tourneyhandler.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="matchs")
@Data
public class Match implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="type_game", length = 50, nullable = false)
	private int typeGame;
	
	@Size(min=3, message="El nombre del juego debe tener un minimo de 3 caracteres")
	@Column(name="name_game", length = 50, nullable = false)
	private String nameGame;
	
	@OneToOne
	@JoinColumn(name="format_id", nullable = false)
	private Format format;
	
	@OneToOne
	@JoinColumn(name="gameResults_id", nullable = false)
	private GameResults gameResults;
	
	@OneToMany(mappedBy = "match", cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private List<Team> team;
	
	@ManyToOne
	@JoinColumn(name="phase_id", nullable = false)
	private Phase phase;

}