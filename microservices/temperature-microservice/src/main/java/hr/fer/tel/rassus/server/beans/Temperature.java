package hr.fer.tel.rassus.server.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="temperature")
public class Temperature {
	@Id
	private Long id;
	
	@Column
	private String temperature;
	
	
	public Temperature() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Temperature(Long id,String temperature) {
		super();
		this.id=id;
		this.temperature = temperature;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	
	
	
}
