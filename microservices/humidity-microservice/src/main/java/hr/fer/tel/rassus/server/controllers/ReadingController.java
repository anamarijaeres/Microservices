package hr.fer.tel.rassus.server.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.tel.rassus.server.beans.Reading;
import hr.fer.tel.rassus.server.repositories.ReadingRepository;
import hr.fer.tel.rassus.server.services.ReadingService;

@RestController
public class ReadingController {

	@Autowired
	private ReadingService readingService;
	
	@Autowired
	private ReadingRepository repo;
	
//	@GetMapping("/currentReading")
//	public Optional<Reading> getCurrentReading() {
//		long seconds= Math.round(System.currentTimeMillis()/1000);
//		int row=(int)((seconds%100)+1);
//		if(row==100) {
//			row=0;
//		}
//		System.out.println(row);
//		return repo.findById((long) row);
//		
//	}

  // TODO 4.3  Spremanje oÄ�itanja pojedinog senzora

  // TODO 4.5  Popis oÄ�itanja pojedinog senzora

}