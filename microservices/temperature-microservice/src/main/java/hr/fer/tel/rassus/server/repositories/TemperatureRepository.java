package hr.fer.tel.rassus.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.fer.tel.rassus.server.beans.Reading;
import hr.fer.tel.rassus.server.beans.Temperature;

public interface TemperatureRepository  extends JpaRepository<Temperature,Long>  {
	

}
