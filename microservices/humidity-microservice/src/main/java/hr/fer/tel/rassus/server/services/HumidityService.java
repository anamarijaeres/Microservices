package hr.fer.tel.rassus.server.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hr.fer.tel.rassus.server.beans.Humidity;
import hr.fer.tel.rassus.server.repositories.HumidityRepository;

@Service
public class HumidityService {
	@Autowired
	public HumidityRepository humidRepository;
	
	public Optional<Humidity> getHumidity(int row) {
		return humidRepository.findById((long) row);
	}
}
