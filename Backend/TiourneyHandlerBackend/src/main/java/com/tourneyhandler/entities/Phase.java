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
@Table(name="phases")
@Data
public class Phase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=3, message="La descripcion debe tener un minimo de 3 caracteres")
	@Column(name="description", length = 50, nullable = false)
	private String description;
	
	@Column(name="stage", length = 50, nullable = false)
	private int stage;
	
	@OneToMany(mappedBy = "phase", cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY)
	private List<Match> match;
	
	@ManyToOne
	@JoinColumn(name="tournament_id", nullable = false)
	private Tournament tournamentP;
	
}