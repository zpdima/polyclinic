package ua.ks.learn.service;

import java.util.List;

import ua.ks.learn.model.Doctor;
import ua.ks.learn.model.Patient;

public interface PatientService {
	
	public Patient findById(Long id);
	
	public List<Patient> getAllPatient();

	public void savePatient(Patient patient);
	
	public void deletePatient(Long id);
	
}
