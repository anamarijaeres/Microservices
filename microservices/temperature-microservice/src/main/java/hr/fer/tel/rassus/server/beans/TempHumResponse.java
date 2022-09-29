package hr.fer.tel.rassus.server.beans;

import java.io.Serializable;

public class TempHumResponse implements Serializable {
	String name;
	String unit;
	int value;
	

	
	public TempHumResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	public TempHumResponse(String name, String unit, String value) {
		super();
		this.name = name;
		this.unit = unit;
		this.value = Integer.valueOf(value);
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
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}


	@Override
	public String toString() {
		return "TempHumResponse [name=" + name + ", unit=" + unit + ", value=" + value + "]";
	}
	
	
	
}
