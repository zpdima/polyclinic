package ua.ks.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.ks.learn.model.Patient;
import ua.ks.learn.repository.PatientRepository;



@Service("patientService")
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	private PatientRepository patientRepository;


	@Override
	public Patient findById(Long id) {
		// TODO Auto-generated method stub
		return patientRepository.getOne(id);
	}

	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public void savePatient(Patient patient) {
		// TODO Auto-generated method stub
		patientRepository.save(patient);

	}
	
	public void deletePatient(Long id) {
		// TODO Auto-generated method stub
		patientRepository.deleteById(id);
	}


}
