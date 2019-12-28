package com.vale.services;

import java.util.List;

import com.vale.entities.Persona;

public interface PersonaService {
	Persona getPersona( Long id );
	Persona createPersona( Persona persona);
	Persona modifica( Long id,  Persona persona );
	void init();
	List<Persona> consulta();
}
