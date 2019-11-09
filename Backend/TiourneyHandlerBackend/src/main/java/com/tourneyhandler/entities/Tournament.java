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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="tournaments")
@Data
public class Tournament implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=3, message="El nombre debe tener un minimo de 3 caracteres")
	@Column(name="name", length = 50, nullable = false)
	private String name;
	
	@Size(min=3, message="El Game Tag debe tener un minimo de 3 caracteres")
	@Column(name="game_tag", length = 50, nullable = false)
	private String gameTag;

	@Size(min=3, message="Los nombres deben tener un minimo de 3 caracteres")
	@Column(name="state", length = 50, nullable = false)
	private String state;
	
	@Column(name="prestige", length = 50, nullable = false)
	private Integer prestige;
	
	@OneToMany(mappedBy = "tournamentT", cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private List<Team> team;
	
	@OneToMany(mappedBy = "tournamentP", cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private List<Phase> phase;
	
	@OneToOne
	@JoinColumn(name="user_id", nullable = false)
	private User user;
	
}