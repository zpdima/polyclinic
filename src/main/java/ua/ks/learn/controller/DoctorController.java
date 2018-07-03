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
import ua.ks.learn.model.Station;
import ua.ks.learn.service.DoctorService;
import ua.ks.learn.service.StationService;

@Controller
public class DoctorController {
	private final Logger logger = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	private StationService stationService;

	@Autowired
	private DoctorService doctorService;

	@RequestMapping(value = "/doctors", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request) {
		logger.info(" --- doctors() " + request.getRemoteAddr() + " (" + request.getRemoteHost() + ")");
		ModelAndView modelAndView = new ModelAndView();
		List<Doctor> doctors = doctorService.getAllDoctor();
		modelAndView.addObject("doctors", doctors);

		modelAndView.addObject("standardDate1", new Date());
		modelAndView.setViewName("doctors");
		return modelAndView;
	}

	@RequestMapping(value = "/adddoctor", method = RequestMethod.GET)
	public ModelAndView addStation(HttpServletRequest request) {
		logger.info(" --- addDoctor() " + request.getRemoteAddr());
		ModelAndView modelAndView = new ModelAndView();
		Doctor doctor = new Doctor();
		modelAndView.addObject("doctor", doctor);

		List<Station> stations = stationService.getAllStation();
		stations.add(0, new Station());
		modelAndView.addObject("stations", stations);

		modelAndView.setViewName("editdoctor");
		return modelAndView;
	}

	@RequestMapping(value = { "doctors/editdoctor", "/editdoctor" }, method = RequestMethod.GET)
	public ModelAndView editStation(Long id) {
		logger.info(" --- edit doctor id = {}", id);
		ModelAndView modelAndView = new ModelAndView();
		Doctor doctor = doctorService.findById(id);
		modelAndView.addObject("doctor", doctor);

		List<Station> stations = stationService.getAllStation();
		stations.add(0, new Station());
		modelAndView.addObject("stations", stations);

		modelAndView.setViewName("editdoctor");
		return modelAndView;
	}

	@RequestMapping(value = { "doctors/editdoctor", "/editdoctor" }, method = RequestMethod.POST)
	public ModelAndView saveStation(@Valid Doctor doctor, BindingResult bindingResult) {
		logger.info(" --- edit doctor id = {}", doctor);
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("editdoctor");
			logger.info(" --- saveDoctor() id = " + doctor.getId());
			logger.info(" --- saveDoctor() Error = " + bindingResult.getAllErrors());
			String errorMessage = "";
			for (ObjectError oe : bindingResult.getAllErrors()) {
				logger.error(" --- " + oe.getCode() + " " + oe.getDefaultMessage());
				errorMessage += (oe.getDefaultMessage() + "<br/>");
			}
			modelAndView.addObject("errorMessage", errorMessage);
			return modelAndView;
		}
		// System.out.println(" --- !!! " + doctor);
		if (doctor.getStation() != null) {
			if (doctor.getStation().getId() == null ) {
				// System.out.println(" --- !!! " + doctor);
				doctor.setStation(null);
			}
		}
		doctorService.saveDoctor(doctor);
		logger.info(" --- saveDoctor() id =" + doctor.getId() + " Ok");
		List<Doctor> doctors = doctorService.getAllDoctor();
		modelAndView.addObject("doctors", doctors);
		modelAndView.addObject("successMessage", "Успешно сохранено");
		modelAndView.setViewName("doctors");

		return modelAndView;
	}

	@RequestMapping(value = { "doctors/deletedoctor", "/deletedoctor" }, method = RequestMethod.GET)
	public ModelAndView delete(Long id) {
		logger.info(" --- delete doctor id = {}", id);
		ModelAndView modelAndView = new ModelAndView();
		doctorService.deleteDoctor(id);
		modelAndView.addObject("successMessage", "Запись удалена");
		List<Doctor> doctors = doctorService.getAllDoctor();
		modelAndView.addObject("doctors", doctors);
		modelAndView.setViewName("doctors");
		return modelAndView;
	}

}
