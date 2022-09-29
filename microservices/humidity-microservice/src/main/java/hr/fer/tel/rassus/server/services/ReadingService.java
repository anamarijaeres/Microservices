package hr.fer.tel.rassus.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import hr.fer.tel.rassus.server.beans.Reading;
import hr.fer.tel.rassus.server.repositories.ReadingRepository;


@Service
public class ReadingService {
	@Autowired
	private ReadingRepository readingRepository;
	
	

	public Optional<Reading> getReading(int row) {
		return readingRepository.findById((long) row);
	}



	
}
