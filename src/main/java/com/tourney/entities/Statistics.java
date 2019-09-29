package com.tourney.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="statistics")
public class Statistics {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="player", nullable= false)
	private Integer player;
	
	@Column(name="kills", nullable = false)
	private Float kills;
	
	@Column(name = "assists", nullable = false)
	private Float assists;
	
	@Column(name = "deaths", nullable = false)
	private Float deaths;
	
	@Column(name = "damagedealt", nullable = false)
	private Float dmgdealt;
	
	@Column(name="damagereceived", nullable = false)
	private Float dmgreceived;
	
	@Column(name="games_played", nullable = false)
	private Integer games_played;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPlayer() {
		return player;
	}

	public void setPlayer(Integer player) {
		this.player = player;
	}

	public Float getKills() {
		return kills;
	}

	public void setKills(Float kills) {
		this.kills = kills;
	}

	public Float getAssists() {
		return assists;
	}

	public void setAssists(Float assists) {
		this.assists = assists;
	}

	public Float getDeaths() {
		return deaths;
	}

	public void setDeaths(Float deaths) {
		this.deaths = deaths;
	}

	public Float getDmgdealt() {
		return dmgdealt;
	}

	public void setDmgdealt(Float dmgdealt) {
		this.dmgdealt = dmgdealt;
	}

	public Float getDmgreceived() {
		return dmgreceived;
	}

	public void setDmgreceived(Float dmgreceived) {
		this.dmgreceived = dmgreceived;
	}

	public Integer getGames_played() {
		return games_played;
	}

	public void setGames_played(Integer games_played) {
		this.games_played = games_played;
	}
	
	
}
