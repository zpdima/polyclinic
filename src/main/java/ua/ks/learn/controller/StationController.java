package ua.ks.learn.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
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

import ua.ks.learn.model.Station;
import ua.ks.learn.service.StationService;


@Controller
public class StationController {
	private final Logger logger = LoggerFactory.getLogger(StationController.class);

	@Autowired
	private StationService stationService;

	@RequestMapping(value =  "/stations", method = RequestMethod.GET)
	public ModelAndView stations(HttpServletRequest request) {
		logger.info(" --- stations() " + request.getRemoteAddr()+" ("+request.getRemoteHost()+")");
		ModelAndView modelAndView = new ModelAndView();
		List<Station> stations = stationService.getAllStation();
		modelAndView.addObject("stations", stations);
		
		modelAndView.addObject("station", new Station());
		modelAndView.addObject("standardDate", new Date());
		modelAndView.setViewName("stations");
		return modelAndView;
	}	
	
	@RequestMapping(value = "/addstation", method = RequestMethod.GET)
	public ModelAndView addStation(HttpServletRequest request) {
		logger.info(" --- addStation() " + request.getRemoteAddr());
		ModelAndView modelAndView = new ModelAndView();
		Station station = new Station();
		modelAndView.addObject("station", station);
		modelAndView.setViewName("editstation");
		return modelAndView;
	}

	
	@RequestMapping(value = {"stations/editstation", "/editstation" }, method = RequestMethod.GET)
	public ModelAndView editStation(Long id) {
		logger.info(" --- edit station id = {}", id);
		ModelAndView modelAndView = new ModelAndView();
		Station station = stationService.findById(id);
		modelAndView.addObject("station", station);
		modelAndView.setViewName("editstation");
		return modelAndView;
	}
	
	@RequestMapping(value = {"stations/editstation", "/editstation" }, method = RequestMethod.POST)
	public ModelAndView saveStation(@Valid Station station, BindingResult bindingResult) {
		logger.info(" --- edit station id = {}", station);
		ModelAndView modelAndView = new ModelAndView();
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("editstation");
			logger.info(" --- saveStation() id = " + station.getId());
			logger.info(" --- saveStation() Error = " + bindingResult.getAllErrors());
			String errorMessage = "";
			for (ObjectError oe : bindingResult.getAllErrors()) {
				logger.error(" --- " + oe.getCode() + " " + oe.getDefaultMessage());
				errorMessage += (oe.getDefaultMessage() + "<br/>");
			}
			modelAndView.addObject("errorMessage", errorMessage);
			return modelAndView;
		}
		
		stationService.saveStation(station);
		logger.info(" --- saveStation() id =" + station.getId() + " Ok");
		List<Station> stations = stationService.getAllStation();
		modelAndView.addObject("stations", stations);
		modelAndView.addObject("successMessage", "Успешно сохранено");
		modelAndView.setViewName("stations");

		return modelAndView;
	}
	
	@RequestMapping(value = { "stations/deletestation", "/deletestation" }, method = RequestMethod.GET)
	public ModelAndView delete(Long id) {
		logger.info(" --- delete station id = {}", id);
		ModelAndView modelAndView = new ModelAndView();
		stationService.deleteStation(id);
		modelAndView.addObject("successMessage", "Запись удалена");
		List<Station> stations = stationService.getAllStation();
		modelAndView.addObject("stations", stations);
		modelAndView.setViewName("stations");
		return modelAndView;
	}
	
	@PostConstruct
	public void init() {
		System.out.println(" --- !!!  init() " + this.getClass());
	}
}
