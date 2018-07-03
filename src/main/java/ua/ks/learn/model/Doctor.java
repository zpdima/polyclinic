package ua.ks.learn.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "id")
	private Long id;
	
	@NotEmpty
	private String fullName;
	
	@NotEmpty
	private String specialization;
	
	@OneToOne
	private Station station;
	
	private String numAp;
	
	private String phones;
	
	@OneToMany
	private Set<Patient> patients = new HashSet<Patient>();
	
	

//	public Doctor() {
//		super();
//		// TODO Auto-generated constructor stub
//		System.out.println(" --- Constructor Doctor()");
//		this.patients =  new HashSet<Patient>();
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public String getNumAp() {
		return numAp;
	}

	public void setNumAp(String numAp) {
		this.numAp = numAp;
	}

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}
	

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	public Set<Patient> getPatients() {
		return patients;
	}

	public void setPatients(Set<Patient> patients) {
		this.patients = patients;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", fullName=" + fullName + ", specialization=" + specialization 
				+ ", station=" + station + ", numAp=" + numAp + ", phones=" + phones + "]";
	}
	
	
	
}
