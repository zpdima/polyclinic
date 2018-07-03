package ua.ks.learn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "schedule")
public class Schedule {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
	private Long id;
	
	@OneToOne
	private Doctor doctor;
	
	@NotEmpty
	private String mon = "-";
	
	@NotEmpty
	private String tue = "-";
	
	@NotEmpty
	private String web = "-";
	
	@NotEmpty
	private String thu = "-";
	
	@NotEmpty
	private String fri = "-";

	@NotEmpty
	private String sat = "-";
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	public String getTue() {
		return tue;
	}

	public void setTue(String tue) {
		this.tue = tue;
	}

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public String getThu() {
		return thu;
	}

	public void setThu(String thu) {
		this.thu = thu;
	}

	public String getFri() {
		return fri;
	}

	public void setFri(String fri) {
		this.fri = fri;
	}

	public String getSat() {
		return sat;
	}

	public void setSat(String sat) {
		this.sat = sat;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", doctor=" + doctor + ", mon=" + mon + ", tue=" + tue + ", web=" + web + ", thu="
				+ thu + ", fri=" + fri + "]";
	}
	
}
