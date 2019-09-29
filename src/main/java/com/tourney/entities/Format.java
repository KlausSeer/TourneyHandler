package com.tourney.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="format")
public class Format {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="format_name", nullable = false)
	private String format_name;
	
	@Column(name="format_desc", nullable = true)
	private String format_desc;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFormat_name() {
		return format_name;
	}

	public void setFormat_name(String format_name) {
		this.format_name = format_name;
	}

	public String getFormat_desc() {
		return format_desc;
	}

	public void setFormat_desc(String format_desc) {
		this.format_desc = format_desc;
	}
	
	
	
	
}
