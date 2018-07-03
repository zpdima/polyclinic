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
import ua.ks.learn.model.Patient;
import ua.ks.learn.service.DoctorService;
import ua.ks.learn.service.PatientService;
import ua.ks.learn.service.StationService;




@Controller
public class PatientController {
	private final Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private StationService stationService;

	@RequestMapping(value =  "/patients", method = RequestMethod.GET)
	public ModelAndView list(HttpServletRequest request) {
		logger.info(" --- patients() " + request.getRemoteAddr()+" ("+request.getRemoteHost()+")");
		ModelAndView modelAndView = new ModelAndView();
		List<Patient> patients = patientService.getAllPatient();
		modelAndView.addObject("patients", patients);
		
		modelAndView.addObject("standardDate", new Date());
		modelAndView.setViewName("patients");
		return modelAndView;
	}	
	
	@RequestMapping(value = "/addpatient", method = RequestMethod.GET)
	public ModelAndView addStation(HttpServletRequest request) {
		logger.info(" --- addPatient() " + request.getRemoteAddr());
		ModelAndView modelAndView = new ModelAndView();
		Patient patient = new Patient();
		modelAndView.addObject("patient", patient);
		
		List<Doctor> doctors = doctorService.getAllDoctor();
		modelAndView.addObject("doctors", doctors);
		
		modelAndView.addObject("stations", stationService.getAllStation());

		
		modelAndView.setViewName("editpatient");
		return modelAndView;
	}

	
	@RequestMapping(value = {"patients/editpatient", "/editpatient" }, method = RequestMethod.GET)
	public ModelAndView editPatient(Long id) {
		logger.info(" --- edit patient id = {}", id);
		ModelAndView modelAndView = new ModelAndView();
		
		Patient patient = patientService.findById(id);
		modelAndView.addObject("patient", patient);

		List<Doctor> doctors = doctorService.getAllDoctor();
		modelAndView.addObject("doctors", doctors);
		
		modelAndView.addObject("stations", stationService.getAllStation());
		
		modelAndView.setViewName("editpatient");
		return modelAndView;
	}
	
	@RequestMapping(value = {"patients/editpatient", "/editpatient" }, method = RequestMethod.POST)
	public ModelAndView saveStation(@Valid Patient patient, BindingResult bindingResult) {
		logger.info(" --- edit station id = {}", patient);
		ModelAndView modelAndView = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("editpatient");
			logger.info(" --- saveStation() id = " + patient.getId());
			logger.info(" --- saveStation() Error = " + bindingResult.getAllErrors());
			String errorMessage = "";
			for (ObjectError oe : bindingResult.getAllErrors()) {
				logger.error(" --- " + oe.getCode() + " " + oe.getDefaultMessage());
				errorMessage += (oe.getDefaultMessage() + "<br/>");
			}
			modelAndView.addObject("errorMessage", errorMessage);
		}
		
		patientService.savePatient(patient);
		logger.info(" --- savePatient() id =" + patient.getId() + " Ok");
		List<Patient> patients = patientService.getAllPatient();
		modelAndView.addObject("patients", patients);
		modelAndView.addObject("successMessage", "Успешно сохранено");
		modelAndView.setViewName("patients");

		return modelAndView;
	}
	
	@RequestMapping(value = { "patients/deletepatient", "/deletespatient" }, method = RequestMethod.GET)
	public ModelAndView delete(Long id) {
		logger.info(" --- delete station id = {}", id);
		ModelAndView modelAndView = new ModelAndView();
		patientService.deletePatient(id);
		modelAndView.addObject("successMessage", "Запись удалена");
		List<Patient> patients = patientService.getAllPatient();
		modelAndView.addObject("patients", patients);
		modelAndView.setViewName("patients");
		return modelAndView;
	}
	
}
