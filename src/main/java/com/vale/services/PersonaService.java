package com.vale.services;

import com.vale.entities.Persona;

public interface PersonaService {
	Persona getPersona( Long id );
	Persona createPersona( Persona persona);
}
