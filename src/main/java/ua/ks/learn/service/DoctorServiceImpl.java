package ua.ks.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.ks.learn.model.Doctor;
import ua.ks.learn.repository.DoctorRepository;



@Service("doctorService")
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;


	@Override
	public Doctor findById(Long id) {
		// TODO Auto-generated method stub
		return doctorRepository.getOne(id);
	}

	@Override
	public List<Doctor> getAllDoctor() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public void saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		doctorRepository.save(doctor);

	}

	@Override
	public void deleteDoctor(Long id) {
		// TODO Auto-generated method stub
		doctorRepository.deleteById(id);;
	}

}
