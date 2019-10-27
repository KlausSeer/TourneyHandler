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
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="teams")
@Data
public class Team implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=3, message="El nombre debe tener un minimo de 3 caracteres")
	@Column(name="name", length = 50, nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private List<Player> player;
	
	@ManyToOne
	@JoinColumn(name="match_id", nullable = false)
	private Phase match;
	
	@ManyToOne
	@JoinColumn(name="tournament_id", nullable = true)
	private Tournament tournamentT;
	
}