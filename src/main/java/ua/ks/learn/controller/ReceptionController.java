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

import ua.ks.learn.model.Reception;
import ua.ks.learn.service.ReceptionService;
import ua.ks.learn.model.Patient;
import ua.ks.learn.service.PatientService;
import ua.ks.learn.model.Doctor;
import ua.ks.learn.service.DoctorService;




@Controller
public class ReceptionController {
	private final Logger logger = LoggerFactory.getLogger(ReceptionController.class);

	@Autowired
	private ReceptionService receptionService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;

	@RequestMapping(value =  "/doctor_receptions", method = RequestMethod.GET)
	public ModelAndView selectDoctor(HttpServletRequest request) {
		logger.info(" --- selectDoctor() " + request.getRemoteAddr()+" ("+request.getRemoteHost()+")");
		ModelAndView modelAndView = new ModelAndView();
		
		
		List<Doctor> doctors = doctorService.getAllDoctor();
		modelAndView.addObject("doctors", doctors);
		
		modelAndView.addObject("standardDate", new Date());
		modelAndView.setViewName("doctor_receptions");
		return modelAndView;
	}	
	
	
	@RequestMapping(value =  {"templates/receptions", "doctor_receptions/receptions", "/receptions"} ,	method = RequestMethod.GET)
	public ModelAndView receptions(HttpServletRequest request, Long doctor_id) {
		logger.info(" --- receptions() doctor id = {} raddr={}", doctor_id, request.getRemoteAddr());
		ModelAndView modelAndView = new ModelAndView();
		
		Doctor doctor = doctorService.findById(doctor_id);
		modelAndView.addObject("doctor", doctor);
		
		List<Reception> receptions = receptionService.geAllReception(doctor);
		modelAndView.addObject("receptions", receptions);
		
		modelAndView.addObject("standardDate", new Date());
		
		modelAndView.setViewName("receptions");
		return modelAndView;
	}	
	
	
	@RequestMapping(value = {"doctor_receptions/addtreception", "addtreception"}, method = RequestMethod.GET)
	public ModelAndView addReception(HttpServletRequest request, Long doctor_id) {
		logger.info(" --- addReception()  doctor id = {} raddr={}", doctor_id, request.getRemoteAddr());
		ModelAndView modelAndView = new ModelAndView();
		
		Reception reception = new Reception();
		reception.setDoctor(doctorService.findById(doctor_id));
		reception.setPatient(patientService.findById(3l));
		reception.setBeginDateTime(new Date());
		
		modelAndView.addObject("reception", reception);
		
		List<Doctor> doctors = doctorService.getAllDoctor();
		modelAndView.addObject("doctors", doctors);
		
		modelAndView.addObject("patients", patientService.getAllPatient());

		
		modelAndView.setViewName("editreception");
		return modelAndView;
	}

	
	@RequestMapping(value = {"/doctor_receptions/printreception", "receptions/printreception", "/printreception" }, method = RequestMethod.GET)
	public ModelAndView print(Long id) {
		logger.info(" --- print schedule id = {}", id);
		ModelAndView modelAndView = new ModelAndView();
		Reception reception = receptionService.findById(id);
		modelAndView.addObject("reception", reception);
		
		
		modelAndView.setViewName("printreception");
		return modelAndView;
	}
	
	@RequestMapping(value = {"receptions/editreception", "/editreception" }, method = RequestMethod.POST)
	public ModelAndView saveStation(@Valid Reception reception, BindingResult bindingResult) {
		logger.info(" --- edit schedule id = {}", reception);
		ModelAndView modelAndView = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("editreception");
			logger.info(" --- saveSchedule() id = " + reception.getId());
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
		
//		reception.setDoctor(doctorService.findById(2l));
//		reception.setPatient(patientService.findById(3l));
		receptionService.saveReception(reception);
		logger.info(" --- saveReception() id =" + reception.getId() + " Ok");
		
		List<Reception> receptions = receptionService.geAllReception(reception.getDoctor());
		modelAndView.addObject("receptions", receptions);
		modelAndView.addObject("doctor", reception.getDoctor());

		
		modelAndView.addObject("successMessage", "Успешно сохранено");
		modelAndView.setViewName("receptions");

		return modelAndView;
	}
	
	@RequestMapping(value = { "doctor_receptions/deletereception", "receptions/deletereception", "/deletereception" }, method = RequestMethod.GET)
	public ModelAndView delete(Long id) {
		logger.info(" --- delete reception id = {}", id);
		
		ModelAndView modelAndView = new ModelAndView();
		Reception reception = receptionService.findById(id);
		receptionService.deleteReception(id);
		modelAndView.addObject("doctor", reception.getDoctor());
		List<Reception> receptions = receptionService.geAllReception(reception.getDoctor());
		modelAndView.addObject("receptions", receptions);
		modelAndView.addObject("successMessage", "Запись удалена");
		modelAndView.setViewName("receptions");
		return modelAndView;
	}
	
}
