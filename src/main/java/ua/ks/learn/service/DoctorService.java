package ua.ks.learn.service;

import java.util.List;

import ua.ks.learn.model.Doctor;

public interface DoctorService {
	
	public Doctor findById(Long id);
	
	public List<Doctor> getAllDoctor();

	public void saveDoctor(Doctor doctor);
	
	public void deleteDoctor(Long id);

}
