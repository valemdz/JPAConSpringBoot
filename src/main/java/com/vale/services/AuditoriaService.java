package com.vale.services;

import java.util.List;

import com.vale.entities.Auditoria;
import com.vale.entities.Persona;

public interface AuditoriaService {
	
	public void log( String event );
	public List<Auditoria> getLogs();
	public void log (Persona persona);

}
