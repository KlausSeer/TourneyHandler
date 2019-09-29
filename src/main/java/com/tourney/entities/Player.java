package com.tourney.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name="players")
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="name", nullable = false)
	private String nombre;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name ="password", nullable= false)
	private String password;
	
	@Column(name = "gamePref", nullable = true)
	private Integer gamePref;
	
	@Column(name ="team", nullable = true)
	private Integer team;
	
	@Column(name = "age", nullable = false)
	private Integer age;
	
	@Column(name = "games_won", nullable = true)
	private Integer games_won;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGamePref() {
		return gamePref;
	}

	public void setGamePref(Integer gamePref) {
		this.gamePref = gamePref;
	}

	public Integer getTeam() {
		return team;
	}

	public void setTeam(Integer team) {
		this.team = team;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGames_won() {
		return games_won;
	}

	public void setGames_won(Integer games_won) {
		this.games_won = games_won;
	}



}
