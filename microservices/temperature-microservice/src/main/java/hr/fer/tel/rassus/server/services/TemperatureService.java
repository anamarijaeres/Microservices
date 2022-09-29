package hr.fer.tel.rassus.server.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.fer.tel.rassus.server.beans.Reading;
import hr.fer.tel.rassus.server.beans.Temperature;
import hr.fer.tel.rassus.server.repositories.TemperatureRepository;

@Service
public class TemperatureService {
	@Autowired
	public TemperatureRepository tempRepository;
	
	public Optional<Temperature> getTemperature(int row) {
		return tempRepository.findById((long) row);
	}

}
