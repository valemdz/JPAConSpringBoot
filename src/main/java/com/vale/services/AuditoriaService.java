package com.vale.services;

import java.util.List;

import com.vale.entities.Auditoria;

public interface AuditoriaService {
	
	public void log( String event );
	public List<Auditoria> getLogs();

}
