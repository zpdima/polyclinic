package ua.ks.learn.service;

import java.util.List;


import ua.ks.learn.model.Station;

public interface StationService {
	
	public Station findById(Long id);
	
	public List<Station> getAllStation();

	public void saveStation(Station station);
	
	public void deleteStation(Long id);

}
