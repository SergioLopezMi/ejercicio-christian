package com.sergio.coches.configuration;

import java.util.logging.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.sergio.coches.domain.Coche;

@Configuration
@ComponentScan(basePackages = "com.sergio.coches.domain")
public class JavaConfig {
	
	private static final Logger LOGGER = Logger.getLogger(JavaConfig.class.getName());
	
	@Scope("singleton")
	@Bean("Coche")
	public Coche crearCoche() {
		LOGGER.info("Creando un nuevo coche");
		
		Coche coche = new Coche();
		
		coche.setMarca("Ford");
		coche.setModelo("Fiesta");
		coche.setMatricula("1234JCV");
		coche.setAnyoFabricacion(2015);
		
		Coche coche2 = new Coche();
		
		coche2.setMarca("Renault");
		coche2.setModelo("Megane");
		coche2.setMatricula("9876RFG");
		coche2.setAnyoFabricacion(2018);
		
		LOGGER.info(coche.toString());
		LOGGER.info(coche2.toString());
		
		return coche;
	}
}
