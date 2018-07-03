package ua.ks.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.ks.learn.model.Doctor;
import ua.ks.learn.model.Reception;
import ua.ks.learn.repository.ReceptionRepository;



@Service("receptionService")
public class ReceptoinServiceImpl implements ReceptionService {
	
	@Autowired
	private ReceptionRepository receptionRepository;


	@Override
	public Reception findById(Long id) {
		// TODO Auto-generated method stub
		return receptionRepository.getOne(id);
	}

	@Override
	public List<Reception> getAllReception() {
		// TODO Auto-generated method stub
		return receptionRepository.findAll();
	}
	

	@Override
	public List<Reception> geAllReception(Doctor doctor) {
		// TODO Auto-generated method stub
		return receptionRepository.findByDoctor(doctor);
	}

	@Override
	public void saveReception(Reception reception) {
		// TODO Auto-generated method stub
		receptionRepository.save(reception);

	}

	@Override
	public void deleteReception(Long id) {
		// TODO Auto-generated method stub
		receptionRepository.deleteById(id);
	}

}
