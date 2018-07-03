package ua.ks.learn.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.ks.learn.model.Doctor;
import ua.ks.learn.model.Schedule;
import ua.ks.learn.model.Station;
import ua.ks.learn.service.DoctorService;
import ua.ks.learn.service.ScheduleService;




@Controller
public class ScheduleController {
	private final Logger logger = LoggerFactory.getLogger(ScheduleController.class);

	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value =  "/schedules", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request) {
		logger.info(" --- schedules() " + request.getRemoteAddr()+" ("+request.getRemoteHost()+")");
		ModelAndView modelAndView = new ModelAndView();
		List<Schedule> schedules = scheduleService.getAllSchedule();
		modelAndView.addObject("schedules", schedules);
		
		modelAndView.addObject("standardDate", new Date());
		modelAndView.setViewName("schedules");
		return modelAndView;
	}	
	
	@RequestMapping(value = "/addschedule", method = RequestMethod.GET)
	public ModelAndView addSchedule(HttpServletRequest request) {
		logger.info(" --- addSchedule() " + request.getRemoteAddr());
		ModelAndView modelAndView = new ModelAndView();
		
		Schedule schedule = new Schedule();
		modelAndView.addObject("schedule", schedule);
			
		List<Doctor> doctors = doctorService.getAllDoctor();
		modelAndView.addObject("doctors", doctors);
		
		modelAndView.setViewName("editschedule");
		return modelAndView;
	}

	
	@RequestMapping(value = {"schedules/editschedule", "/editschedule" }, method = RequestMethod.GET)
	public ModelAndView editStation(Long id) {
		logger.info(" --- edit schedule id = {}", id);
		ModelAndView modelAndView = new ModelAndView();
		Schedule schedule = scheduleService.findById(id);
		modelAndView.addObject("schedule", schedule);
		
		List<Doctor> doctors = doctorService.getAllDoctor();
		modelAndView.addObject("doctors", doctors);
		
		modelAndView.setViewName("editschedule");
		return modelAndView;
	}
	
	@RequestMapping(value = {"schedules/editschedule", "/editschedule" }, method = RequestMethod.POST)
	public ModelAndView saveStation(@Valid Schedule schedule, BindingResult bindingResult) {
		logger.info(" --- edit schedule id = {}", schedule);
		ModelAndView modelAndView = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("editschedule");
			logger.info(" --- saveSchedule() id = " + schedule.getId());
			logger.info(" --- saveSchedule() Error = " + bindingResult.getAllErrors());
			String errorMessage = "";
			for (ObjectError oe : bindingResult.getAllErrors()) {
				logger.error(" --- " + oe.getCode() + " " + oe.getDefaultMessage());
				errorMessage += (oe.getDefaultMessage() + "<br/>");
			}
			modelAndView.addObject("errorMessage", errorMessage);
			return modelAndView;
		}
//		if(schedule.getDoctor().getId() == null) {
//			schedule.setDoctor(null);
//		}
		scheduleService.saveSchedule(schedule);
		logger.info(" --- saveSchedule() id =" + schedule.getId() + " Ok");
		List<Schedule> schedules = scheduleService.getAllSchedule();
		modelAndView.addObject("schedules", schedules);
		modelAndView.addObject("successMessage", "Успешно сохранено");
		modelAndView.setViewName("schedules");

		return modelAndView;
	}
	
	@RequestMapping(value = { "schedules/deleteschedule", "/deleteschedule" }, method = RequestMethod.GET)
	public ModelAndView delete(Long id) {
		logger.info(" --- delete schedule id = {}", id);
		ModelAndView modelAndView = new ModelAndView();
		scheduleService.deleteSchedule(id);
		modelAndView.addObject("successMessage", "Запись удалена");
		List<Schedule> schedules = scheduleService.getAllSchedule();
		modelAndView.addObject("schedules", schedules);
		modelAndView.setViewName("schedules");
		return modelAndView;
	}
	
}
