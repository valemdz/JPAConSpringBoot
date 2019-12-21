package com.vale.services;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vale.entities.Persona;


@Service
@Transactional( readOnly = true )
public class PersonaServiceImpl implements PersonaService {
	
	@PersistenceContext 
	EntityManager em;
	
	@Override
	public Persona getPersona(Long id) {
		
		//Persona persona = em.find( Persona.class, id );
		
		Persona persona = em.getReference( Persona.class, id );		
		return persona;
	}

	
	@Override
	@Transactional( readOnly = false )
	public Persona createPersona( Persona persona ) {
		
		em.persist(persona);
		
		return persona;
	}

}
