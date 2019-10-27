package com.tourneyhandler.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name="statisticss")
@Data
public class Statistics implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=3, message="El K/D/A debe tener el formato correcto")
	@Column(name="KDA", length = 50, nullable = false)
	private String KDA;
	
	@OneToOne
	@JoinColumn(name="player_id", nullable = false)
	private Tournament player;

}