package ua.ks.learn.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.ks.learn.model.Station;
import ua.ks.learn.repository.StationRepository;



@Service("stationService")
public class StationServiceImpl implements StationService {
	
	@Autowired
	private StationRepository stationRepository;

	@Override
	public Station findById(Long id) {
		// TODO Auto-generated method stub
		return stationRepository.getOne(id);
	}

	@Override
	public List<Station> getAllStation() {
		// TODO Auto-generated method stub
		return stationRepository.findAll();
	}

	@Override
	public void saveStation(Station station) {
		// TODO Auto-generated method stub
		stationRepository.save(station);

	}

	@Override
	public void deleteStation(Long id) {
		// TODO Auto-generated method stub
		stationRepository.deleteById(id);
	}
	
	
	
	public StationServiceImpl() {
		System.out.println(" --- !!!  StationServiceImpl() " + this.getClass());
	}

	@PostConstruct
	public void init() {
		System.out.println(" --- !!!  init() " + this.getClass());
	}
	
	@PreDestroy
	public void pre() {
		System.out.println(" --- !!!  @PreDestroy " + this.getClass());
	}

}
