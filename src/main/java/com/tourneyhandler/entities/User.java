package com.tourneyhandler.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/* 
	@Size(min=3, message="Los nombres deben tener un maximo de 3 caracteres")
	@Column(name="name", length = 50, nullable = false)
	private String name;
	
	@Size(min=3, message="El email debe tener un maximo de 3 caracteres")
	@Column(name="email", length = 50, nullable = false)
	private String email;
	
	@Size(min=3, message="El username debe tener un maximo de 3 caracteres")
	@Column(name="username", length = 50, nullable = false)
	private String username;
	
	@Size(min=3, message="El password debe tener un maximo de 3 caracteres")
	@Column(name="password", length = 50, nullable = false)
	private String password;
	*/

}