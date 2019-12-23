package com.vale.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Auditoria {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	private String event;	
	
	public Auditoria() {	
	}
	
	public Long getId() {
		return id;
	}
	public String getEvent() {
		return event;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	
	
}
