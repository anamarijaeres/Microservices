package hr.fer.tel.rassus.server;

import java.io.File;
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
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.opencsv.bean.CsvToBeanBuilder;

import hr.fer.tel.rassus.server.beans.Humidity;
import hr.fer.tel.rassus.server.beans.Reading;
import hr.fer.tel.rassus.server.repositories.HumidityRepository;
import hr.fer.tel.rassus.server.repositories.ReadingRepository;


@SpringBootApplication
@EnableEurekaClient
public class Application implements CommandLineRunner {
	@Autowired
	private ReadingRepository readingRepo;
	
	
	
	@Autowired
	private HumidityRepository humidRepo;
	@Autowired
	private ResourceLoader resourceLoader;
	
	
  public static void main(String[] args) {
	System.setProperty("proxyHost", "yourproxy.server-humidity.com");
	System.setProperty("proxyPort", "8093");
    SpringApplication.run(Application.class, args);
 
  }

  	@Override
	public void run(String... args) throws Exception {
  		
  		InputStream is = getClass().getResourceAsStream("/mjerenja.csv");
  		
  		
//  		Resource resource = resourceLoader.getResource("classpath:mjerenja.csv");
//  		File file = resource.getFile();
  		
  		List<Reading> readings = new CsvToBeanBuilder<Reading>(new InputStreamReader(is))
  		       .withType(Reading.class).build().parse();
  		
  		long l=0;
  		for(Reading reading: readings)
  			reading.setId(l++);
  		
  
  		List<Humidity> humidList=new ArrayList<>();
  		l=0;
  		for(Reading reading: readings) {
  			humidList.add(new Humidity(l++,reading.getHumidity()));
  		}
  		
  		readingRepo.saveAll(readings);
  		humidRepo.saveAll(humidList);
  			
  		readings.stream().forEach(System.out::println);
		
	}
}
