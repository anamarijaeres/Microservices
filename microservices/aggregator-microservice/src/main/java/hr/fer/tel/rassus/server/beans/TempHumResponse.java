package hr.fer.tel.rassus.server.beans;

import java.io.Serializable;

public class TempHumResponse implements Serializable {
	String name;
	String unit;
	double value;
	

	
	public TempHumResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TempHumResponse(String name, String unit, String value) {
		super();
		this.name = name;
		this.unit = unit;
		this.value = Double.valueOf(value);
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double d) {
		this.value = d;
	}


	@Override
	public String toString() {
		return "TempHumResponse [name=" + name + ", unit=" + unit + ", value=" + value + "]";
	}
	
	
	
}
