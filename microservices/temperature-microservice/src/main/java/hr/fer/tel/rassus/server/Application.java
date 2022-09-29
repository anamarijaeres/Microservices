package hr.fer.tel.rassus.server;

import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import com.opencsv.bean.CsvToBeanBuilder;


import hr.fer.tel.rassus.server.beans.Reading;
import hr.fer.tel.rassus.server.beans.Temperature;
import hr.fer.tel.rassus.server.repositories.TemperatureRepository;
import hr.fer.tel.rassus.server.repositories.ReadingRepository;


@SpringBootApplication
@EnableEurekaClient
public class Application implements CommandLineRunner {
	@Autowired
	private ReadingRepository readingRepo;
	
	@Autowired
	private TemperatureRepository tempRepo;
	
  public static void main(String[] args) {
	System.setProperty("proxyHost", "localhost");
	System.setProperty("proxyPort", "8092");
    SpringApplication.run(Application.class, args);
 
  }

  	@Override
	public void run(String... args) throws Exception {
  		InputStream is = getClass().getResourceAsStream("/mjerenja.csv");
  		
  		List<Reading> readings = new CsvToBeanBuilder<Reading>(new InputStreamReader(is))
  		       .withType(Reading.class).build().parse();
  		
  		long l=0;
  		for(Reading reading: readings)
  			reading.setId(l++);
  		
  		List<Temperature> tempList=new ArrayList<>();
 
  		l=0;
  		for(Reading reading: readings) {
  			tempList.add(new Temperature(l,reading.getTemperature()));
  			
  		}
  		
  		readingRepo.saveAll(readings);
  		tempRepo.saveAll(tempList);
  			
  		readings.stream().forEach(System.out::println);
		
	}
}
