package com.tourney.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@Entity 
@Table (name="tournament")
public class Tournament {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "tdatestart", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date tdatestart;
	
	@Column(name = "tdateend", nullable = true)
	private Date tdateend;
	
	@Column(name = "totalteams", nullable = true)
	private Integer totalTeams;
	
	@Column(name = "format", nullable = true)
	private Integer format;
	
	@Column(name = "winner", nullable = true)
	private Integer winner;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getTdatestart() {
		return tdatestart;
	}

	public void setTdatestart(Date tdatestart) {
		this.tdatestart = tdatestart;
	}

	public Date getTdateend() {
		return tdateend;
	}

	public void setTdateend(Date tdateend) {
		this.tdateend = tdateend;
	}

	public Integer getTotalTeams() {
		return totalTeams;
	}

	public void setTotalTeams(Integer totalTeams) {
		this.totalTeams = totalTeams;
	}

	public Integer getFormat() {
		return format;
	}

	public void setFormat(Integer format) {
		this.format = format;
	}

	public Integer getWinner() {
		return winner;
	}

	public void setWinner(Integer winner) {
		this.winner = winner;
	}
	
	
}
