package com.vale.services;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vale.entities.Persona;
import com.vale.repositories.PersonaRepository;


@Service
@Transactional( readOnly = true )
public class PersonaServiceImpl implements PersonaService {
	
	@Autowired
	PersonaRepository personaRepository;

	@Override
	public Persona getPersona(Long id) {
		Persona persona = personaRepository.findById(id).get();
		return persona;
	}

	@Transactional( readOnly = false )
	@Override
	public Persona createPersona( Persona persona ) {
		return personaRepository.save( persona );
	}

}
