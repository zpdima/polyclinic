package ua.ks.learn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "reception")
public class Reception {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
	private Long id;
	
//	@NotEmpty
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	@Temporal(TemporalType.TIMESTAMP)
	private Date beginDateTime;
	
	@OneToOne
	private Doctor doctor;
	
	@OneToOne
	private Patient patient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBeginDateTime() {
		return beginDateTime;
	}

	public void setBeginDateTime(Date beginDateTime) {
		this.beginDateTime = beginDateTime;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Override
	public String toString() {
		return "Reception [id=" + id + ", beginDateTime=" + beginDateTime + ", doctor=" + doctor + ", patient="
				+ patient + "]";
	}
	

}
