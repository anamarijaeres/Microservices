package hr.fer.tel.rassus.server.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hr.fer.tel.rassus.server.beans.Reading;

public interface ReadingRepository extends JpaRepository<Reading,Long>  {
	Optional<Reading> findBysensorId(Long row);
}
