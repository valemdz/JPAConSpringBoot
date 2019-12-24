package com.vale.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vale.entities.Persona;


@Service
@Transactional( readOnly = true )
public class PersonaServiceImpl implements PersonaService {
	
	@PersistenceContext 
	EntityManager em;
	
	@Autowired AuditoriaService auditoriaService;
	
	@Override
	@Transactional( readOnly = false )
	public Persona getPersona(Long id) {
		
		Persona persona = em.find( Persona.class, id );		
		auditoriaService.log( persona );
		
		if( persona.getConsultas() > 3  ) {
			throw new RuntimeException("Demasiadas Consultas");
		}
		
		return persona;
	}

	
	@Override
	@Transactional( readOnly = false )
	public Persona createPersona( Persona persona ) {
		
		
		auditoriaService.log( "Se dio de alta a " + persona.toString() );
		
		em.persist(persona);
		
		return persona;
	}

}
