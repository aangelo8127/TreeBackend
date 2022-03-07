package com.mo.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mo.dominio.puerto.repositorio.RepositorioArbol;
import com.mo.infraestructura.adaptador.repositorio.ImplementacionRepositorioArbol;
import com.mo.infraestructura.adaptador.repositorio.RepositorioArbolH2;

@Configuration
public class BeanServicio {

	@Bean
	public RepositorioArbol getRepositorioArbol(RepositorioArbolH2 repositorioArbolH2) {
		return new ImplementacionRepositorioArbol(repositorioArbolH2);
	}
	
}
