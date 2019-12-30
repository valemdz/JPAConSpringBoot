package com.vale.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.vale.entities.Persona;


@Component
public class WebService {
	
	
	Logger logger = LoggerFactory.getLogger( WebService.class );
	
	public String consultaAntecedentes( Persona persona ) {
		
		logger.info( " Esperando info de Antecedentes" + Thread.currentThread().getName() );
		
		try {
			
			Thread.sleep(1000*20);
			
		}catch( InterruptedException ex ) {
			logger.error( "error" + ex.getMessage() );
		}
		
		logger.info( " Entregar Respuesta " );
		
		return "Todo salio bastante mal";
	}

}
