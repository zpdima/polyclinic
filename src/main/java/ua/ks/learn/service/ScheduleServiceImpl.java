package ua.ks.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.ks.learn.model.Doctor;
import ua.ks.learn.model.Schedule;
import ua.ks.learn.repository.DoctorRepository;
import ua.ks.learn.repository.ScheduleRepository;



@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleRepository scheduleRepository;


	@Override
	public Schedule findById(Long id) {
		// TODO Auto-generated method stub
		return scheduleRepository.getOne(id);
	}

	@Override
	public List<Schedule> getAllSchedule() {
		// TODO Auto-generated method stub
		return scheduleRepository.findAll();
	}

	@Override
	public void saveSchedule(Schedule schedule) {
		// TODO Auto-generated method stub
		scheduleRepository.save(schedule);

	}

	@Override
	public void deleteSchedule(Long id) {
		// TODO Auto-generated method stub
		scheduleRepository.deleteById(id);
	}

}
