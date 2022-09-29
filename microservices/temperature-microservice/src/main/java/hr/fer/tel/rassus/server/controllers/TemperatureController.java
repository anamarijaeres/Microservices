package hr.fer.tel.rassus.server.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hr.fer.tel.rassus.server.beans.Reading;
import hr.fer.tel.rassus.server.beans.TempHumResponse;
import hr.fer.tel.rassus.server.beans.Temperature;
import hr.fer.tel.rassus.server.services.ReadingService;
import hr.fer.tel.rassus.server.services.TemperatureService;

@RestController
public class TemperatureController {

	
	@Autowired
	private ReadingService readingService;
	
	@Autowired
	private TemperatureService temperatureService;
	
	
	@GetMapping("/temperature/currentReading")
	public TempHumResponse getCurrentReading() {
		long seconds= Math.round(System.currentTimeMillis()/1000);
		int row=(int)((seconds%100)+1);
		if(row==100) {
			row=0;
		}
		System.out.println(row);
		Optional<Reading> reading=readingService.getReading(row);
		if(reading.isPresent()) {
			return new TempHumResponse("Temperature","C",reading.get().getTemperature());
		}else {
			return null;
		}
	}
	
	@GetMapping("/temp/currentReading")
	public TempHumResponse getCurrentReadingTemp() {
		long seconds= Math.round(System.currentTimeMillis()/1000);
		int row=(int)((seconds%100)+1);
		if(row==100) {
			row=0;
		}
		System.out.println(row);
		Optional<Temperature> temperature=temperatureService.getTemperature(row);
		System.out.println(temperature.isPresent());
		if(temperature.isPresent()) {
			return new TempHumResponse("Temperature","C",temperature.get().getTemperature());
		}else {
			return null;
		}
	}
}
