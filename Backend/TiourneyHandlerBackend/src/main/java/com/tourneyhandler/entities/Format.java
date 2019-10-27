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
@Table(name="formats")
@Data
public class Format implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min=3, message="El nombre debe tener un mínimo de 3 caracteres")
	@Column(name="name", length = 20, nullable = false)
	private String name;
	
	@Size(min=6, message="La descripcion tener un mínimo de 6 caracteres")
	@Column(name="description", length = 20, nullable = false)
	private String description;

	@OneToOne
	@JoinColumn(name="match_id", nullable = false)
	private Match match;
	
}
