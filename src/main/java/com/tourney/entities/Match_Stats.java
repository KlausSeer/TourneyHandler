package com.tourney.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="match_stats")
public class Match_Stats {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="match_id", nullable = false)
	private Integer match_id;
	
	@Column(name = "player_id", nullable = false)
	private Integer player_id;
	
	@Column(name="kills", nullable = false)
	private Float kills;
	
	@Column(name = "assists", nullable = false)
	private Float assists;
	
	@Column(name="deaths", nullable=false)
	private Float deaths;
	
	@Column(name = "damagedealt", nullable = false)
	private Float dmgdealt;
	
	@Column(name="damagereceived", nullable = false)
	private Float dmgreceived;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMatch_id() {
		return match_id;
	}

	public void setMatch_id(Integer match_id) {
		this.match_id = match_id;
	}

	public Integer getPlayer_id() {
		return player_id;
	}

	public void setPlayer_id(Integer player_id) {
		this.player_id = player_id;
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
	
	
}
