package com.vale.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vale.entities.Persona;


@Service
@Transactional( readOnly = true )
public class PersonaServiceImpl implements PersonaService {
	
	private static int MILES = 150;
	
	@PersistenceContext 
	EntityManager em;
	
	@Override
	public Persona getPersona(Long id) {
		
		Persona persona = em.find( Persona.class, id );
		
		//Persona persona = em.getReference( Persona.class, id );		
		return persona;
	}

	
	@Override
	@Transactional( readOnly = false )
	public Persona createPersona( Persona persona ) {
		
		em.persist(persona);
		
		return persona;
	}


	@Override
	@Transactional( readOnly = true )
	public Persona modifica(Long id, Persona persona) {
		Persona personaModificada = getPersona(id);
		personaModificada.setNombre( persona.getNombre() );
		
		return persona;
	}


	@Override
	@Transactional( readOnly = true )
	public void init() {	
		
		for( int i=0; i < ( MILES * 1000L ); i++ ){
			Persona persona = new Persona();
			persona.setNombre( "Persona" + (i+1) );
			persona.setDni( "Dni" + (i+1) );
			em.persist(persona);
		}
		
	}


	@Override
	@Transactional( readOnly = true )
	public List<Persona> consulta() {
		
		List<Persona> personas = new ArrayList< Persona >( (MILES * 1000)  );
		
		
		TypedQuery<Persona> query = em.createQuery( "Select p from Persona p where p.id >= :inicio and p.id <= :fin ", 
													Persona.class );
		
		
		for( int i=0; i < MILES; i++ ) {
			
			query.setParameter("inicio", ( i*1000L ) + 1 );
			query.setParameter("fin", ( i+1 ) * 1000L );
			
			personas.addAll( query.getResultList() );
		}
		
		return personas;
		
	}

}
