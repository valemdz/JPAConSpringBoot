package com.vale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vale.entities.Auditoria;
import com.vale.entities.Persona;
import com.vale.services.AuditoriaService;
import com.vale.services.PersonaService;

@RestController
public class MiController {
	
	@Autowired PersonaService personaService;	
	@Autowired AuditoriaService auditoriaService; 		
	
	
	@GetMapping("/")
	@ResponseStatus( HttpStatus.OK )
	Persona saytHello(){
		Persona persona = new Persona();
		persona.setNombre("Valeria del Valle Torres");
		return persona;
	}
	
	@GetMapping("/persona/{id}")
	@ResponseStatus( HttpStatus.OK )
	public Persona getPersona( @PathVariable  Long id ){		
		Persona persona = personaService.getPersona(id);
		return persona;
	}
	
	@PostMapping("/persona")
	@ResponseStatus( HttpStatus.CREATED )
	public Persona createPersona( @RequestBody Persona persona ) {
		return personaService.createPersona(persona);		
	}
	
	@GetMapping("/logs")
	@ResponseStatus( HttpStatus.OK )
	public List< Auditoria > getLogs(){		
		return auditoriaService.getLogs();		
	}
	
	
}
