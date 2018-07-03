package ua.ks.learn.service;

import java.util.List;


import ua.ks.learn.model.Schedule;

public interface ScheduleService {
	
	public Schedule findById(Long id);
	
	public List<Schedule> getAllSchedule();

	public void saveSchedule(Schedule schedule);
	
	public void deleteSchedule(Long id);

}
