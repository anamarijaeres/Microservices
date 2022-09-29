package hr.fer.tel.rassus.server.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="humidity")
public class Humidity {
	@Id
	private Long id;
	
	@Column
	private String humidity;

	
	
	public Humidity() {
		super();
	}

	public Humidity(Long id,String humidity) {
		super();
		this.id=id;
		this.humidity = humidity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	
	
}
