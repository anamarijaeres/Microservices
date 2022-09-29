package hr.fer.tel.rassus.server.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.tel.rassus.server.beans.Humidity;
import hr.fer.tel.rassus.server.beans.Reading;
import hr.fer.tel.rassus.server.beans.TempHumResponse;
import hr.fer.tel.rassus.server.services.HumidityService;
import hr.fer.tel.rassus.server.services.ReadingService;

@RestController
public class HumidityController {
	@Autowired
	private ReadingService readingService;
	
	@Autowired
	private HumidityService humidityService;
	
	@GetMapping("/humidity/currentReading")
	public TempHumResponse getCurrentReading() {
		long seconds= Math.round(System.currentTimeMillis()/1000);
		int row=(int)((seconds%100)+1);
		if(row==100) {
			row=0;
		}
		System.out.println(row);
		Optional<Reading> reading=readingService.getReading(row);
		if(reading.isPresent()) {
			return new TempHumResponse("Humidity","%",reading.get().getHumidity());
		}else {
			return null;
		}
	}
	@GetMapping("/humid/currentReading")
	public TempHumResponse getCurrentReadingHumid() {
		long seconds= Math.round(System.currentTimeMillis()/1000);
		int row=(int)((seconds%100)+1);
		if(row==100) {
			row=0;
		}
		System.out.println(row);
		Optional<Humidity> humidity=humidityService.getHumidity(row);
		if(humidity.isPresent()) {
			return new TempHumResponse("Humidity","%",humidity.get().getHumidity());
		}else {
			return null;
		}
	}
}
