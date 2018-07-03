package ua.ks.learn.service;

import java.util.List;

import ua.ks.learn.model.Doctor;
import ua.ks.learn.model.Reception;

public interface ReceptionService {
	
	public Reception findById(Long id);
	
	public List<Reception> getAllReception();
	
	public List<Reception> geAllReception(Doctor doctor);

	public void saveReception(Reception reception);
	
	public void deleteReception(Long id);

}
