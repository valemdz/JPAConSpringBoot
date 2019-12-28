package com.vale.controllers;


import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vale.entities.Persona;
import com.vale.services.PersonaService;

@RestController
public class MiController {
	
	private Logger logger = LoggerFactory.getLogger( MiController.class );
	
	/*@Value("${spring.jpa.open-in-view}")
	private String openInView;*/
	
	@Autowired PersonaService personaService;
	
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
	
	@GetMapping("/consultaMunicipio/{id}")
	@ResponseStatus( HttpStatus.OK )
	public String consultaMunicipio( @PathVariable  Long id ){		
		Persona persona = personaService.getPersona(id);		
		return persona.getMunicipio();
	}
	
	@GetMapping("/consulta/{id}")
	@ResponseStatus( HttpStatus.OK )
	public boolean getConsulta( @PathVariable  Long id ){	
		log();
		Persona primera = personaService.getPersona(id);
		Persona segunda = personaService.getPersona(id);
		return primera == segunda;
	}
	
	@PutMapping("/persona/{id}")
	@ResponseStatus( HttpStatus.OK )
	public String modificarPersona(@PathVariable Long id, @RequestBody Persona persona ) {
		 personaService.modifica( id, persona);
		 return personaService.getPersona(id).getNombre();
	}
	
	private void log() {
		logger.info("El sistema open en view que estamos utilizando" + true);
		
	}
	
	
	@PostConstruct
	void init() {
		
		logger.info("Iniciando la base de datos");
		
		personaService.init();
		
		logger.info("Finalizacion inicializacion!!!");
	}
	
	
	@GetMapping("/consulta")
	@ResponseStatus( HttpStatus.OK )
	public List<Persona> getConsulta(  ){	
		
		StopWatch sp = new StopWatch();
		sp.start("consulta");
		
		List<Persona> personas = personaService.consulta();
		
		
		sp.stop();
		logger.info( sp.prettyPrint());
		logger.info( "Segundos" + String.valueOf( sp.getTotalTimeSeconds() ));
		
		return personas;
	}
	
	
}
