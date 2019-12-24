package com.vale.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vale.entities.Auditoria;
import com.vale.entities.Persona;


@Service
@Transactional( propagation = Propagation.REQUIRES_NEW )
public class AuditoriaServiceImpl implements AuditoriaService {
	
	@PersistenceContext
	EntityManager em;

	
   public void log (Persona persona) {
		
		Auditoria auditoria = new Auditoria();
		String mensaje = String.format("Consulta num %d a %s", persona.getConsultas(), persona.getNombre());
		auditoria.setEvent(mensaje);

		persona.setConsultas(persona.getConsultas()+1);

		em.persist(auditoria);
	}
	

	@Override
	public void log(String event) {
		
		Auditoria auditoria = new Auditoria();
		auditoria.setEvent(event);
		
		em.persist(auditoria);
		
	}

	@Override
	public List<Auditoria> getLogs() {
		return em.createQuery( "Select a from Auditoria a order by a.id", Auditoria.class ).getResultList();
	}
	
	
	

}
