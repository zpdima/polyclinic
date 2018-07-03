package ua.ks.learn.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "station")
public class Station {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@NotEmpty
	private String streets;
	
	@OneToMany
	private Set<Doctor> doctors = new HashSet<Doctor>();
	
	@OneToMany
	private Set<Patient> patients = new HashSet<Patient>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreets() {
		return streets;
	}

	public void setStreets(String streets) {
		this.streets = streets;
	}

	public Set<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(Set<Doctor> doctors) {
		this.doctors = doctors;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Station [id=" + id + ", streets=" + streets + ", doctors=" + doctors + ", patients=" + patients + "]";
	}

	
	
}
