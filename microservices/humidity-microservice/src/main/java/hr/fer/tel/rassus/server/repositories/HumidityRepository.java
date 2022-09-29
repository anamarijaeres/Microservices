package hr.fer.tel.rassus.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.fer.tel.rassus.server.beans.Humidity;

public interface HumidityRepository extends JpaRepository<Humidity,Long>  {

}
