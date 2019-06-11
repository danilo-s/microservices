package it.danilo.microservices.domain;

import java.io.Serializable;

public enum Region implements Serializable{
	Central_Coast("Central Coast"),Southern_California("Southern_California"),
	Northern_California("Northern_California"),Varies("Varies");
	
	private String label;
	
	private Region(String label) {
		this.label=label;
	}
	
	public static Region findByLabel(String label) {
		for(Region r:Region.values()) {
			if(r.label.equalsIgnoreCase(label))
				return r;
		}
		return null;
	}
	
	
}
